/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;

/**
 *
 * @author nguye_000
 */
public class Player {
    private int x;
    private int y;
    private int speed;
    private Circle playerChar;
    private Translate charTranslate;
    private Room currRoom;
    private Room prevRoom;
    private int maxHeight;
    private int maxWidth;
    private Weapon weapon;
    private Group playerPane;
    private PositionEnum pos;
    private int health;
    private int money;
    private Inventory inventory;
    private final int maxHP;
    private ItemHandler itemHandler;
    public Player() {
        x = 500;
        y = 500;
        speed = 30;
        playerChar = new Circle(getX(), getY(), 20);
        charTranslate = new Translate();
        playerChar.getTransforms().addAll(charTranslate);
        maxWidth = 1616;
        maxHeight = 876;
        weapon = new BasicSword(x, y, maxWidth, maxHeight);
        inventory = new Inventory(getWeapon(), this);
        pos = PositionEnum.RIGHT;
        health = 100;
        maxHP = 100;
        itemHandler = new ItemHandler();
    }
    public void move(int dx, int dy) {
        Shape weaponIcon = getWeapon().getIcon();
        this.setX(((this.getX() + maxWidth + dx * getSpeed()) % maxWidth));
        this.setY(((this.getY() + maxHeight + dy * getSpeed()) % maxHeight));
        playerChar.setCenterX(this.getX());
        playerChar.setCenterY(this.getY());
        itemHandler.checkItemCollision(this, currRoom);
        
    }
    public void turnLeft() {
        pos = PositionEnum.LEFT;
    }
    public void turnRight() {
        pos = PositionEnum.RIGHT;
    }
    public void turnUp() {
        pos = PositionEnum.UP;
    }
    public void turnDown() {
        pos = PositionEnum.DOWN;
    }
    /**
     public void attack() {
     Weapon weapon = getWeapon();
     weapon.move(getX(), getY());
     if (getPos() == PositionEnum.DOWN) {
     weapon.rotate(0);
     } else if (getPos() == PositionEnum.LEFT){
            weapon.rotate(90);
        } else if (getPos() == PositionEnum.RIGHT){
            weapon.rotate(270);
        } else {
            weapon.rotate(180);
        }
        
        currRoom.removeWeapon(getWeapon());
        view.addWeapon(weapon);
      }
      **/

    /**
     * @return the playerChar
     */
    public Circle getPlayerChar() {
        return playerChar;
    }

    /**
     * @param playerChar the playerChar to set
     */
    public void setPlayerChar(Circle playerChar) {
        this.playerChar = playerChar;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the currRoom
     */
    public Room getCurrRoom() {
        return currRoom;
    }

    /**
     * @param currRoom the currRoom to set
     */
    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }
    public void setPrevRoom(Room prevRoom) {
        this.prevRoom = prevRoom;
    }
    public Room getPrevRoom() {
        return prevRoom;
    }
    public int getSpeed() {
        return speed;
    }
    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the maxHeight
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * @param maxHeight the maxHeight to set
     */
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    /**
     * @return the maxWidth
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * @param maxWidth the maxWidth to set
     */
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * @return the weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * @param weapon the weapon to set
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * @return the playerPane
     */
    public Group getPlayerPane() {
        return playerPane;
    }

    /**
     * @param playerPane the playerPane to set
     */
    public void setPlayerPane(Group playerPane) {
        this.playerPane = playerPane;
    }

    /**
     * @return the pos
     */
    public PositionEnum getPos() {
        return pos;
    }
    public int beAttacked(int attack) {
        health = this.health - attack;
        return health;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int hp) {
        this.health = hp;
    }
    /**
     * @return the money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money the money to set
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * @return the player's inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * @return the maxHP
     */
    public int getMaxHP() {
        return maxHP;
    }
}
