/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 *
 * @author nguye_000
 */
public class ExitRoom extends Room {
    private Text exit;
    private Button exitButton;
    public ExitRoom(int width, int height) throws Exception {
        super(width, height);
        exit = new Text("Exit Room");
        exitButton = new Button("ExitHere");
        getPane().setCenter(exit);
        getPane().setRight(exitButton);
        this.generateMonsters();
    }
    public Monster generateMonsters() throws Exception {
        Monster monster = new Boss();
        addMonster(monster);
        return monster;
    }
}
