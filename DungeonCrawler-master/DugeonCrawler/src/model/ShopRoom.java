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
public class ShopRoom extends Room {
    private Text shop;
    public ShopRoom(int width, int height) throws Exception {
        super(width, height);
        shop = new Text("Shop Room");
        getPane().setCenter(shop);
        generateMonster();
    }
    public Monster generateMonster() throws Exception {
        Monster monster = new Werewolf(100);
        addMonster(monster);
        return monster;
    }

}
