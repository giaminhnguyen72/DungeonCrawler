/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author nguye_000
 */
public class ConfigurationScreen {
    
    private Button quitButton;
    private Button nextButton;
    private TextField nameTextField;
    private ToggleGroup difficultyGroup;
    private ToggleGroup startingWeaponGroup;
    private int width;
    private int height;
    public ConfigurationScreen(int width, int height) {
        this.width = width;
        this.height = height;
        difficultyGroup = new ToggleGroup();
        startingWeaponGroup = new ToggleGroup();
        nameTextField = new TextField("");
        quitButton = new Button("Quit");
        nextButton = new Button("Next");
    }
    private VBox setupDifficulty() {
        Label difficultyText = new Label("Difficulty");
        RadioButton easy = new RadioButton("Easy");
        RadioButton medium = new RadioButton("Medium");
        RadioButton hard = new RadioButton("Hard");

        easy.setToggleGroup(difficultyGroup);
        medium.setToggleGroup(difficultyGroup);
        hard.setToggleGroup(difficultyGroup);
        VBox difficulty = new VBox(difficultyText, easy, medium, hard);
        return difficulty;
    }
    private VBox setupName() {
        Label enterNameText = new Label("Enter Name: ");

        VBox name = new VBox(enterNameText, nameTextField);
        return name;
    }
    private VBox setupStartingWeapon() {
        Label weaponLabel = new Label("Select Starting Weapon:");
        RadioButton bowButton = new RadioButton("Basic Bow");
        RadioButton swordButton = new RadioButton("Basic Sword");
        RadioButton axeButton = new RadioButton("Basic Axe");

        bowButton.setToggleGroup(startingWeaponGroup);
        swordButton.setToggleGroup(startingWeaponGroup);
        axeButton.setToggleGroup(startingWeaponGroup);
        VBox mainContainer = new VBox(weaponLabel, swordButton, axeButton, bowButton);
        return mainContainer;
    }
    public Scene getScene() {
        HBox configBox = new HBox(setupName(), setupStartingWeapon(), setupDifficulty());
        HBox buttonBox = new HBox(getQuitButton(), getNextButton());
        VBox everything = new VBox(configBox, buttonBox);
        Scene scene = new Scene(everything, getWidth(), getHeight());
        return scene;
    }

    /**
     * @return the quitButton
     */
    public Button getQuitButton() {
        return quitButton;
    }

    /**
     * @return the nextButton
     */
    public Button getNextButton() {
        return nextButton;
    }

    /**
     * @return the nameTextField
     */
    public TextField getNameTextField() {
        return nameTextField;
    }

    /**
     * @return the difficultyGroup
     */
    public ToggleGroup getDifficultyGroup() {
        return difficultyGroup;
    }

    /**
     * @return the startingWeaponGroup
     */
    public ToggleGroup getStartingWeaponGroup() {
        return startingWeaponGroup;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }
    
}
