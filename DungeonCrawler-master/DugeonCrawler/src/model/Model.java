/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.CongratsScreen;
import view.GameScreen;

import java.util.ArrayList;

/**
 *
 * @author nguye_000
 */
public class Model {
    private GameScreen view;
    private int money;
    private int mazeSize;
    private Room[][] mazeArray;
    private Player player;
    private int roomXIndex;
    private int roomYIndex;
    private int difficulty;
    private int screenWidth;
    private int screenHeight;
    private AttackHandler attackController;
    private int totalAttacks;
    private int damageDealt;
    private int totalHits;
    public Model() {
        player = new Player();
        attackController = new AttackHandler();
        totalAttacks = 0;
        damageDealt = 0;
        totalHits = 0;
    }
    public void makeMaze(int size) throws Exception {
        screenWidth = 1616;
        screenHeight = 876;
        mazeSize = size;
        mazeArray = new Room[mazeSize][mazeSize];
        roomXIndex = mazeSize / 2;
        roomYIndex = mazeSize / 2;
        mazeArray[roomYIndex][roomXIndex] = new StartingRoom(screenWidth, screenHeight);
        player.setCurrRoom(mazeArray[roomYIndex][roomXIndex]);
        mazeArray[mazeSize - 1][mazeSize - 1] = new ExitRoom(screenWidth, screenHeight);
        for (int x = 0; x < mazeArray[0].length; x++) {
            for (int y = 0; y < mazeArray.length; y++) {
                if (mazeArray[y][x] == null) {
                    mazeArray[y][x] = createRoom();
                }
            }
        }
        player.setMaxHeight(screenHeight);
        player.setMaxWidth(screenWidth);
        player.setPrevRoom(mazeArray[roomYIndex][roomXIndex]);
    }
    public void increaseMoney(int amount) {
        setMoney(money + amount);
    }
    public int getMoney() {
        return money;
    }
    public boolean changeRoom(int x, int y) {
        view.updateMoneyLabel();
        // changed this method to return a boolean
        // because I needed to see if the room was actually changed
        if (mazeArray[roomYIndex][roomXIndex] instanceof ExitRoom
                && !mazeArray[roomYIndex][roomXIndex].containsMonster()) {
            view.getStage().close();
            CongratsScreen congratsScreen = new CongratsScreen(
                    damageDealt, totalHits, totalAttacks);
            return false;
        }
        // if the room is a monster room, check if the monster is alive.
        // if it is, don't change rooms if the intended room isn't the previous room.
        // the player will still bounce to the other side of the room, but it's not a new room.
        if (x != roomXIndex || roomYIndex != y) {
            Weapon weapon = player.getWeapon();
            if (weapon.isEffect()) {
                weapon.setAttackDamage(weapon.getAttackDamage() / 2);
                weapon.setEffect(false);
            }
        }
        if (mazeArray[roomYIndex][roomXIndex].containsMonster()) {
            if (mazeArray[y][x].isVisited()) {
                if (x >= 0 && x < mazeArray[0].length) {
                    if (y >= 0 && y < mazeArray.length) {
                        roomXIndex = x;
                        roomYIndex = y;
                        player.setPrevRoom(player.getCurrRoom());
                        player.setCurrRoom(mazeArray[roomYIndex][roomXIndex]);
                        mazeArray[roomYIndex][roomXIndex].setVisited(true);
                        mazeArray[roomYIndex][roomXIndex].getPane()
                                .setBottom(player.getPlayerPane());
                        getView().setCurrScene(mazeArray[roomYIndex][roomXIndex]);
                        handleKeyBoard(mazeArray[roomYIndex][roomXIndex].getScene(), player);
                        System.out.println("Test1");
                    }
                }
            } else {
                System.out.println("Test2");
            }
        } else {
            if (x >= 0 && x < mazeArray[0].length) {
                if (y >= 0 && y < mazeArray.length) {
                    roomXIndex = x;
                    roomYIndex = y;
                    player.setPrevRoom(player.getCurrRoom());
                    player.setCurrRoom(mazeArray[roomYIndex][roomXIndex]);
                    mazeArray[roomYIndex][roomXIndex].setVisited(true);
                    mazeArray[roomYIndex][roomXIndex].getPane().setBottom(player.getPlayerPane());
                    getView().setCurrScene(mazeArray[roomYIndex][roomXIndex]);
                    handleKeyBoard(mazeArray[roomYIndex][roomXIndex].getScene(), player);
                    System.out.println("Test3");
                }
            } else {
                System.out.println("Test4");
            }
        }
        //      while (player.getCurrRoom().equals(mazeArray[roomYIndex][roomXIndex])) {
        moveMonster(getCurrRoom());
        //            try {
        //                Thread.sleep(1000);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //        }
        return false;

    }
    public void movePlayer(int dx, int dy) {
        if (player.getX() + dx * player.getSpeed() < 0) {
            changeRoom(roomXIndex - 1, roomYIndex);
        }
        if (player.getX() + dx * player.getSpeed() > screenWidth) {
            changeRoom(roomXIndex + 1, roomYIndex);
        }
        if (player.getY() + dy * player.getSpeed() > screenHeight) {
            changeRoom(roomXIndex, roomYIndex + 1);
        }
        if (player.getY() + dy * player.getSpeed() < 0) {
            changeRoom(roomXIndex, roomYIndex - 1);
        }
        // if the room is locked, then the player won't warp to the other side.
        // problem is that player will continue
        // to move past the length even if the room doesn't change
        player.move(dx, dy);
        player.getWeapon().move(dx, dy);
    }
    public void attack() {
        Weapon weapon = player.getWeapon();
        weapon.move(player.getX(), player.getY());
        if (player.getPos() == PositionEnum.DOWN) {
            weapon.rotate(0);
        } else if (player.getPos() == PositionEnum.LEFT) {
            weapon.rotate(90);
        } else if (player.getPos() == PositionEnum.RIGHT) {
            weapon.rotate(270);
        } else {
            weapon.rotate(180);
        }
        
        view.removeWeapon(player.getWeapon());
        view.addWeapon(weapon);
        boolean hit = attackController.checkWeaponCollision(
                player.getWeapon(), player.getCurrRoom());
        if (hit) {
            totalHits++;
            damageDealt += player.getWeapon().getAttackDamage();
        }
        attackController.checkWeaponCollision(player.getWeapon(), player.getCurrRoom());
    }
    
    public void stopAttack() {
        view.removeWeapon(player.getWeapon());
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * @return the difficulty
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public Room getCurrRoom() {
        return mazeArray[roomYIndex][roomXIndex];
    }
    public Room createRoom() throws Exception {
        int random = (int) (Math.random() * 100);
        if (random < 25) {
            return new ChallengeRoom(screenWidth, screenHeight);
        } else if (random < 50) {
            return new MonsterRoom(screenWidth, screenHeight);
        } else if (random < 75) {
            return new TreasureRoom(screenWidth, screenHeight);
        } else {
            return new ShopRoom(screenWidth, screenHeight);
        }
    }
    /**
     * @return the screenWidth
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     * @param screenWidth the screenWidth to set
     */
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    /**
     * @return the screenHeight
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * @param screenHeight the screenHeight to set
     */
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }
    private void handleKeyBoard(Scene scene, Player player) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (null != event.getCode()) {
                    switch (event.getCode()) {
                        case W:
                            movePlayer(0, -1);
                            player.turnUp();
                            break;
                        case S:
                            movePlayer(0, 1);
                            player.turnDown();
                            break;
                        case A:
                            movePlayer(-1, 0);
                            player.turnLeft();
                            break;
                        case D:
                            movePlayer(1, 0);
                            player.turnRight();
                            break;
                        case L:
                            attack();
                            break;
                        default:
                            break;
                    }
                }
            }
            
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (null != event.getCode() && event.getCode() == KeyCode.L) {
                    stopAttack();
                    totalAttacks++;
                }
            }
        });
    }

    /**
     * @return the view
     */
    public GameScreen getView() {
        return view;
    }

    /**
     * @param view the view to set
     */
    public void setView(GameScreen view) {
        this.view = view;
    }
    /**
     * @return the roomXIndex
     */
    public int getRoomXIndex() {
        return roomXIndex;
    }
    /**
     * @return the roomYIndex
     */
    public int getRoomYIndex() {
        return roomYIndex;
    }
    /**
     * @return the mazeArray
     */
    public Room[][] getMazeArray() {
        return mazeArray;
    }

    public void moveMonster(Room room) {
        ArrayList<Monster> list = room.getMonsterList();
        if (list.size() == 0 && !(room instanceof ChallengeRoom)) {
            return;
        }
        
        AnimationTimer timer;
        timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    if (list.size() == 0 || player.getHealth() <= 0) {
                        if (!(room instanceof ChallengeRoom)) {
                            stop();
                        }
                    }
                    if (player.getHealth() <= 0) {
                        stop();
                    }
                    for (int i = 0; i < list.size(); i++) {
                        Monster currMonster = list.get(i);
                        currMonster.setX(currMonster.getX() + (i * 40));
                    }
                    for (int i = 0; i < list.size(); i++) {
                        Monster currMonster = list.get(i);
                    
                    System.out.println(
                            "coordinates of player: "
                                    + currMonster.getX() + " " + currMonster.getY());
                    if (currMonster.getX() <= 1285 && currMonster.getY() <= 100) {
                        currMonster.move(5, 0);
                        //                    System.out.println(1);
                    } else if (currMonster.getX() >= 1285 && currMonster.getY() <= 685) {
                        currMonster.move(0, 5);
                        //                    System.out.println(2);
                    } else if (currMonster.getX() >= 100 && currMonster.getY() >= 685) {
                        currMonster.move(-5, 0);
                        //                    System.out.println(3);
                    } else if (currMonster.getX() <= 100 && currMonster.getY() >= 100) {
                        currMonster.move(0, -5);
                        //                    System.out.println(4);
                        }
                    currMonster.checkMonsterCollision(
                            player, view.getStage(), damageDealt, totalHits, totalAttacks);
                    view.updateMoneyLabel();
                    //        if (list.get(0).getX() == 500 && list.get(0).getY() < 500) {
                    //            list.get(0).move(0, 1);
                    //        } else if (list.get(0).getY() == 500 && list.get(0).getX() < 500) {
                    //            list.get(0).move(1, 0);
                    //        } else if (list.get(0).getY() == 0) {
                    //            list.get(0).move(0, 1);
                    //        }
                    //        list.get(0).move(1, 0);
                    } }
            };
        timer.start();
        //        if (list.size() > 0 && list.get(0).isAlive()) {
        //            list.get(0).move(1, 1);
        //        }
    }
}

