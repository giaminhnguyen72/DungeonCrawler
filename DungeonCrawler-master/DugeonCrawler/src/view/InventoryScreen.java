package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Inventory;
import model.Useable;
import model.Weapon;

/**
 * @author sramaswami30
 * @version 4.4.21
 */
public class InventoryScreen {
    private Inventory inventory;
    private int width;
    private int height;
    private Button resumeButton;
    private ToggleGroup weaponGroup;
    private ToggleGroup potionGroup;
    private VBox weapons;
    private VBox items;
    public InventoryScreen(Inventory inventory, int width, int height) {
        this.inventory = inventory;
        this.width = width;
        this.height = height;
        resumeButton = new Button("Resume");
        weaponGroup = new ToggleGroup();
        weapons = new VBox(new Label("Weapons: "));
        items = new VBox(new Label("Items: "));
    }

    /**
     * @return the scene
     */
    public Scene getScene() {
        
        for (Weapon w : inventory.getWeapons()) {
            RadioButton radioButton = new RadioButton(w.getName());
            radioButton.setToggleGroup(weaponGroup);
            weapons.getChildren().add(radioButton);
            if (w == inventory.getPlayer().getWeapon()) {
                radioButton.setSelected(true);
            }
        }
        addChangeListener(weaponGroup);
        for (Useable w : inventory.getItems()) {
            if (!(w instanceof Weapon)) {
                Button button = new Button(w.getName());
                items.getChildren().add(button);
                addButtonListener(button);
            }
        }
        //        potionGroup = new ToggleGroup();
        //        for (Potion p : inventory.getWeapons()) {
        //            RadioButton radioButton = new RadioButton(p.getName());
        //            radioButton.setToggleGroup(weaponGroup);
        //            potions.getChildren().add(radioButton);
        //        }
        HBox hBox = new HBox(weapons, items, resumeButton);
        hBox.setSpacing(100);
        Scene scene = new Scene(hBox, width, height);
        return scene;
    }

    /**
     * @return the resume button
     */
    public Button getResumeButton() {
        return resumeButton;
    }

    /**
     * @return the potion group
     */
    public ToggleGroup getPotionGroup() {
        return potionGroup;
    }

    /**
     * @return the weapon group
     */
    public ToggleGroup getWeaponGroup() {
        return weaponGroup;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public void addButtonListener(Button button) {
        button.setOnAction(e -> {
            int index = items.getChildren().indexOf(button) - 1;
            items.getChildren().remove(button);
            Useable item = (Useable) inventory.getItems().remove(index);
            item.use(inventory.getPlayer());
        });
    }
    public void addChangeListener(ToggleGroup group) {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(
                    ObservableValue<? extends Toggle> observable,
                    Toggle oldValue, Toggle newValue) {
                if (group.getSelectedToggle() != null) {
                    RadioButton selected = (RadioButton) group.getSelectedToggle();
                    
                    for (int i = 1; i < weapons.getChildren().size(); i++) {
                        RadioButton curr = (RadioButton) weapons.getChildren().get(i);
                        if (selected == curr) {
                            inventory.getPlayer().setWeapon(inventory.getWeapons().get(i - 1));
                        }
                    }
                }
            }
           
        });
    }
    
}
