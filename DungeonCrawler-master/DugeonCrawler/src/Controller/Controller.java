/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.Weapon;
import view.ConfigurationScreen;
import view.GameScreen;
import view.InventoryScreen;
import view.WelcomeScreen;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Player;

/**
 *
 * @author nguye_000
 */
public class Controller extends Application {
    private Stage main;
    private Model gameModel;
    private final int width = 1000;
    private final int height = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        main = primaryStage;
        main.setTitle("Dungeon Crawler");
        gameModel = new Model();
        initializeGame();
    }
    private void initializeGame() {
        WelcomeScreen screen = new WelcomeScreen(width, height);
        Button playButton = screen.getPlayButton();
        playButton.setOnAction(e -> {
            gotoConfigScreen();
        });
        Button quitButton = screen.getQuitButton();
        quitButton.setOnAction(e -> {
            main.close();
        });
        Button testButton = screen.getTestButton();
        testButton.setOnAction(e -> {
            try {
                startGame();
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Scene scene = screen.getScene();
        main.setScene(scene);
        main.show();
    }
    private void gotoConfigScreen() {
        ConfigurationScreen config = new ConfigurationScreen(width, height);
        setupDifficultyToggle(config);
        Button nextButton = config.getNextButton();
        TextField nameField = config.getNameTextField();
        handleNextButton(nextButton, nameField);
        Button quitButton = config.getQuitButton();
        quitButton.setOnAction(e -> {
            main.close();
        });
        Scene scene = config.getScene();
        main.setScene(scene);
        main.show();
    }

    private void handleNextButton(Button nextButton, TextField nameField) {
        nextButton.setOnAction(e -> {
            if (nameField.getText() == null
                    || nameField.getText().trim().length() == 0
                    || nameField.getText().isEmpty()) {
                nameField.setText("Error; Type in a name");
            } else {
                try {
                    startGame();
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void startGame() throws Exception {
        System.out.println("IN START GAME");

        GameScreen screen = new GameScreen((int) main.getWidth(), (int) main.getHeight());
        Player player = gameModel.getPlayer();
        Button inventoryButton = screen.getInventoryButton();
        inventoryButton.setOnAction(e -> {
            goToInventoryScreen();
        });
        screen.setStage(main);
        screen.setPlayer(player);
        gameModel.setScreenWidth((int) main.getWidth());
        gameModel.setScreenHeight((int) main.getHeight());
        gameModel.makeMaze(7);
        screen.setPlayerChar(player.getPlayerChar());
        //Scene scene = gameModel.getCurrRoom().getScene();
        screen.setCurrScene(gameModel.getCurrRoom());
        //      screen.setCurrScene(gameModel.getCurrRoom(), inventoryButton);
        //changeScene(scene);
        screen.updateMoneyLabel(gameModel.getMoney());
        main.setMaximized(true);
        //        System.out.println(main.getWidth());
        //        System.out.println(main.getHeight());
        main.setMinWidth((int) main.getWidth());
        main.setMinHeight((int) main.getHeight());
        handleKeyBoard(gameModel.getCurrRoom().getScene(), player);
        gameModel.setView(screen);
    }

    private void changeScene(Scene scene) {
        Player player = gameModel.getPlayer();
        handleKeyBoard(scene, player);
        main.setScene(scene);
        main.show();
    }

    private void handleKeyBoard(Scene scene, Player player) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (null != event.getCode()) {
                    switch (event.getCode()) {
                        case W:
                            gameModel.movePlayer(0, -1);
                            player.turnUp();
                            break;
                        case S:
                            gameModel.movePlayer(0, 1);
                            player.turnDown();
                            break;
                        case A:
                            gameModel.movePlayer(-1, 0);
                            player.turnLeft();
                            break;
                        case D:
                            gameModel.movePlayer(1, 0);
                            player.turnRight();
                            break;
                        case L:
                            gameModel.attack();
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
                    gameModel.stopAttack();
                }
            }
        });
    }
    private void setupDifficultyToggle(ConfigurationScreen config) {
        ToggleGroup difficultyGroup = config.getDifficultyGroup();
        difficultyGroup.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> observable,
                 Toggle oldValue, Toggle newValue) -> {
                    RadioButton toggled = (RadioButton) difficultyGroup.getSelectedToggle();
                    switch (toggled.getText()) {
                    case "Easy":
                        gameModel.setDifficulty(0);
                        gameModel.setMoney(1000);
                        break;
                    case "Medium":
                        gameModel.setDifficulty(1);
                        gameModel.setMoney(500);
                        break;
                    case "Hard":
                        gameModel.setDifficulty(2);
                        gameModel.setMoney(250);
                        break;
                    default:
                        break;
                    }
                });
    }
    private void goToInventoryScreen() {
        InventoryScreen inventoryScreen = new InventoryScreen(
                gameModel.getPlayer().getInventory(), width, height);
        inventoryToggles(inventoryScreen);
        Button resumeButton = inventoryScreen.getResumeButton();
        resumeButton.setOnAction(e -> {
            gameModel.changeRoom(gameModel.getRoomXIndex(), gameModel.getRoomYIndex());
        });
        Scene scene = inventoryScreen.getScene();
        main.setScene(scene);
        main.show();
    }
    private void inventoryToggles(InventoryScreen inventoryScreen) {
        ToggleGroup weaponGroup = inventoryScreen.getWeaponGroup();
        weaponGroup.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> observable,
             Toggle oldValue, Toggle newValue) -> {
                RadioButton toggled = (RadioButton) weaponGroup.getSelectedToggle();
                for (Weapon w : inventoryScreen.getInventory().getWeapons()) {
                    if (w.getName().equals(toggled.getText())) {
                        gameModel.getPlayer().setWeapon(w);
                        break;
                    }
                }
            }
        );
        //        ToggleGroup potionGroup = inventoryScreen.getPotionGroup();
        //        weaponGroup.selectedToggleProperty().addListener(
        //                (ObservableValue<? extends Toggle> observable,
        //                 Toggle oldValue, Toggle newValue) -> {
        //                    RadioButton toggled = (RadioButton) potionGroup.getSelectedToggle();
        //                    for (Potion p : inventoryScreen.getInventory().getWeapons()) {
        //                        if (p.getName().equals(toggled.getText())) {
        //                            gameModel.getPlayer().setWeapon(p);
        //                            break;
        //                        }
        //                    }
        //                }
        //        );
    }
    public Model getGameModel() {
        return gameModel;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
