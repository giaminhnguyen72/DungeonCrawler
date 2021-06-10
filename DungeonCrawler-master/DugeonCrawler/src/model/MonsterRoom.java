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
public class MonsterRoom extends Room {
    private Text monster;
    private Werewolf randomMonster;
    public MonsterRoom(int width, int height) throws Exception {
        super(width, height);
        monster = new Text("Monster Room!");
        getPane().setCenter(monster);
        generateMonster();
    
    }
    public Monster getMonster() {
        return randomMonster;
    }
    public Monster generateMonster() throws Exception {
        Monster monster = new Bigfoot(100);
        addMonster(monster);
        return monster;
    }
}
