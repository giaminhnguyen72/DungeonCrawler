package view;

import controller.Controller;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 * author : harry
 */
public class LossScreen {
    private Stage stage;
    private Scene scene;
    private BorderPane pane;
    private Button restartButton;
    private Button endButton;
    private VBox textBox;
    private Text text;
    private Text stats;
    public LossScreen() {
        this.stage = new Stage();
        pane = new BorderPane();
        text = new Text("Better luck next time!");
        textBox = new VBox();
        textBox.getChildren().add(text);
        restartButton = new Button("Click to restart game");
        endButton = new Button("End Game");
        pane.setCenter(textBox);
        HBox box = new HBox();
        box.getChildren().addAll(restartButton, endButton);
        pane.setBottom(box);
        scene = new Scene(pane, 500, 500);
        handleButton(restartButton);
        handleEndButton(endButton);
        stage.setScene(scene);
        stage.show();
        System.out.println("created");
    }
    public LossScreen(int damageDealt, int totalHits, int totalAttacks) {
        this();
        this.stats = new Text("Damage Dealt: " + damageDealt
                + "\nTotal Hits: "
                + totalHits + "\nTotal Attacks: " + totalAttacks);
        textBox.getChildren().add(stats);
    }
    public Button getRestartButton() {
        return restartButton;
    }

    private void handleButton(Button button) {
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
    private void handleEndButton(Button button) {
        button.setOnAction(e -> {
            stage.close();
        });
    }

    public Text getText() {
        return text;
    }

    public Text getStats() {
        return stats;
    }
}
