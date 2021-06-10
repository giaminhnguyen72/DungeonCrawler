/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.*;


/**
 *
 * @author nguye_000, jchen844
 */
public class GameScreen {
    private Label moneyLabel;
    private int width;
    private int height;
    private Circle playerChar;
    private Scene currScene;
    private Room currRoom;
    private Stage stage;
    private Player player;
    private Monster monster;
    private Button inventoryButton;
    public GameScreen(int width, int height) {
        this.width = width;
        this.height = height;
        moneyLabel = new Label();
        inventoryButton = new Button("check inventory");
    }
    public void updateMoneyLabel(int newMoney) {
        moneyLabel.setText(Integer.toString(newMoney) + " Hp: " + player.getHealth());
    }
    public void updateMoneyLabel() {
        moneyLabel.setText(Integer.toString(100) + " Hp: " + player.getHealth());
    }
    public Scene getInitialScene() {
        BorderPane mainPane = new BorderPane();
        Pane group = new Pane(playerChar);
        mainPane.setTop(moneyLabel);
        mainPane.getChildren().add(playerChar);
        Scene scene = new Scene(mainPane, width, height);
        return scene;
    }
    public Node getPlayerChar() {
        return playerChar;
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

    /**
     * @param playerChar the playerChar to set
     */
    public void setPlayerChar(Node playerChar) {
        this.playerChar = (Circle) playerChar;
    }

    /**
     * @return the currScene
     */
    public Scene getCurrScene() {
        return currScene;
    }

    /**
     * @param currScene the currScene to set
     */
    public void setCurrScene(Scene currScene) {
        this.currScene = currScene;
        stage.setScene(currScene);
        stage.show();
    }
    public void setCurrScene(Room room) {
        currRoom = room;
        if (currScene == null) {
            System.out.println("dsgs");
        }
        HBox hBox = new HBox(moneyLabel, inventoryButton);
        //      room.getPane().setTop(moneyLabel);
        room.getPane().setTop(hBox);
        Pane group = new Pane(playerChar);
        room.getPane().getChildren().addAll((playerChar));
        System.out.println(stage + " " + room.getScene());
        stage.setScene(room.getScene());
        stage.show();
        
        stage.setScene(room.getScene());
        stage.show();   
    }
    public void setCurrScene(Room room, Button button) {
        currRoom = room;
        HBox hBox = new HBox(moneyLabel, button);
        //        room.getPane().setTop(moneyLabel);
        room.getPane().setTop(hBox);
        room.getPane().getChildren().addAll(playerChar);
        stage.setScene(room.getScene());
        stage.show();
    }
    public void addWeapon(Weapon weapon) {
        currRoom.getPane().getChildren().add(player.getWeapon().getIcon());
    }
    public void removeWeapon(Weapon weapon) {
        currRoom.getPane().getChildren().remove(weapon.getIcon());
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * @param player the player to set
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Button getInventoryButton() {
        return inventoryButton;
    }
}
