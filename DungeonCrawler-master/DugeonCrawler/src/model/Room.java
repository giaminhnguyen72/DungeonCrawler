/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



/**
 *
 * @author nguye_000
 */
public abstract class Room {
    private Scene scene;
    private int width;
    private int height;
    private BorderPane pane;
    private boolean visited;
    private ArrayList<Monster> monsterList;
    private ArrayList<Useable> itemList;
    public Room(int width, int height) {
        pane = new BorderPane();
        scene = new Scene(pane, width, height);
        monsterList = new ArrayList<>();
        itemList = new ArrayList<>();
        visited = false;
    }
    
    /**
     * @return the scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the pane
     */
    public BorderPane getPane() {
        return pane;
    }

    /**
     * @param pane the pane to set
     */
    public void setPane(BorderPane pane) {
        this.pane = pane;
    }
    public void addMonster(Monster monster) {
        getMonsterList().add(monster);
        pane.getChildren().add(monster.getIcon());
    }
    public void removeMonster(Monster monster) {
        getMonsterList().remove(monster);
        pane.getChildren().remove(monster.getIcon());
        Useable item = generateItem(monster.getX(), monster.getY());
        pane.getChildren().add(item.getIcon());
    }
    public void clearMonsterList() {
        while (!monsterList.isEmpty()) {
            pane.getChildren().remove(monsterList.get(0).getIcon());
            monsterList.remove(monsterList.get(0));
        }
    }
    public void removeItem(Useable item) {
        getItemList().remove(item);
        pane.getChildren().remove(item.getIcon());
    }
    public Useable generateItem(int x, int y) {
        int random = (int) (Math.random() * 4);
        Useable item;
        if (random < 1) {
            item = new HealthPotion(x, y);
            
        } else if (random < 2) {
            item = new AttackPotion(x, y);
        } else if (random < 3) {
            item = new LightSaber(x, y, width, height);
        } else {
            item = new SpeedPotion(x, y);
        }
        getItemList().add(item);
        return item;
    }

    /**
     * @return the visited
     */
    public boolean isVisited() {
        return visited;
    }
    
    /**
     * @param visited the visited to set
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the monsterList
     */
    public ArrayList<Monster> getMonsterList() {
        return monsterList;
    }

    /**
     * @param monsterList the monsterList to set
     */
    public void setMonsterList(ArrayList<Monster> monsterList) {
        this.monsterList = monsterList;
    }
    public boolean isRoomEmpty() {
        return monsterList.size() == 0;
    }
    public boolean containsMonster() {
        return monsterList.size() != 0;
    }

    /**
     * @param scene the scene to set
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    //    public void moveMonster() {
    //        AnimationTimer timer = new AnimationTimer() {
    //            @Override
    //            public void handle(long now) {
    //                monsterList.get(0).move(1, 1);
    //                if (this.equals(player.getCurrRoom()))
    //            }
    //        }
    //        if (monsterList.size() > 0 && monsterList.get(0).isAlive()) {
    //            monsterList.get(0).move(1, 1);
    //        }
    //    }

    /**
     * @return the itemList
     */
    public ArrayList<Useable> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(ArrayList<Useable> itemList) {
        this.itemList = itemList;
    }
}
