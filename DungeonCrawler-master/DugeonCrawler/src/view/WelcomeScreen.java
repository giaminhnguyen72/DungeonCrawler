/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author nguye_000
 */
public class WelcomeScreen {
    private Button playButton;
    private Button quitButton;
    private Button testButton;
    private int width;
    private int height;
    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        playButton = new Button("Play");
        quitButton = new Button("Quit");
        testButton = new Button("Test");
        getScene();
    }
    public Scene getScene() {
        HBox buttonBox = new HBox(playButton, quitButton, testButton);
        Scene scene = new Scene(buttonBox, width, height);
        return scene;
    }

    /**
     * @return the playButton
     */
    public Button getPlayButton() {
        return playButton;
    }

    /**
     * @return the quitButton
     */
    public Button getQuitButton() {
        return quitButton;
    }

    /**
     * @return the testButton
     */
    public Button getTestButton() {
        return testButton;
    }
}
