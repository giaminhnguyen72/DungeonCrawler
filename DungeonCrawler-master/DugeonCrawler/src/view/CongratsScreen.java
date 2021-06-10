/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nguye_000
 */
public class CongratsScreen {
    private Stage stage;
    private Scene scene;
    private BorderPane pane;
    private Text congrats;
    private Text stats;
    private Button button;
    private Button endButton;
    private Button restartButton;
    public CongratsScreen() {
        stage = new Stage();
        pane = new BorderPane();
        congrats = new Text("Congrats you escaped and won the game");
        button = new Button();
        
        handleButton(button);
        endButton = new Button("End Game");
        pane.setCenter(congrats);
        scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    public CongratsScreen(int damageDealt, int totalHits, int totalAttacks) {
        stage = new Stage();
        pane = new BorderPane();
        congrats = new Text("Congrats you escaped and won the game");
        stats = new Text(
                "Damage Dealt: " + damageDealt
                        + "\nTotal Hits: "
                        + totalHits + "\nTotal Attacks: " + totalAttacks);
        VBox box = new VBox();
        box.getChildren().addAll(congrats, stats);
        button = new Button("Exit Game");
        restartButton = new Button("Restart");
        handleButton(button);
        handleButton2(restartButton);
        HBox buttons = new HBox();
        buttons.getChildren().addAll(restartButton, button);
        pane.setCenter(box);
        pane.setBottom(buttons);
        scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
    public void handleButton(Button button) {
        button.setOnAction(e -> {
            stage.close();
        });
    }
    public void handleButton2(Button button) {
        button.setOnAction(e -> {
            this.stage.close();
            Controller control = new Controller();
            try {
                control.start(new Stage());
                
            } catch (Exception ex) {
                Logger.getLogger(LossScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }


    public Button getButton() {
        return button;
    }

    public Text getCongrats() {
        return congrats;
    }

    public Text getStats() {
        return stats;
    }
}
