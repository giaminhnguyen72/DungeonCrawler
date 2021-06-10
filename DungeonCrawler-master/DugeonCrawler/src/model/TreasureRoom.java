/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.text.Text;

/**
 *
 * @author nguye_000
 */
public class TreasureRoom extends Room {
    private Text treasure;
    public TreasureRoom(int width, int height) throws Exception {
        super(width, height);
        treasure = new Text("Treasure Room");
        getPane().setCenter(treasure);
        generateMonster();
    }
    
    public Monster generateMonster() throws Exception {
        Monster monster = new Dragon();
        addMonster(monster);
        return monster;
    }
}
