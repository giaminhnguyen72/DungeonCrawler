/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.control.Button;

/**
 *
 * @author nguye_000
 */
public class ChallengeRoom extends Room {
    private Button challengeButton;
    public ChallengeRoom(int width, int height) {
        super(width, height);
        challengeButton = new Button("Challenge");
        getPane().setCenter(challengeButton);
        addListener(challengeButton);
    }
    
    public Monster generateMonster() {
        System.out.println("in generateMonsters()");
        Monster monster1 = new Dragon();
        //        monster1.setX(100);
        //        monster1.setY(100);
        addMonster(monster1);

        Monster monster2 = new Bigfoot();
        //        monster2.setX(1285);
        //        monster2.setY(100);
        addMonster(monster2);

        Monster monster3 = new Dragon();
        //        monster3.setX(1285);
        //        monster3.setY(685);
        addMonster(monster3);
        return monster3;
    }
    public void addListener(Button button) {
        button.setOnAction(e -> {
            getPane().getChildren().remove(button);
            generateMonster();
        });
    }
}
