/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author nguye_000
 */
public class HealthPotion extends Potion {
    private int healedHP;
    private Shape sprite;
    private double x;
    private double y;
    public HealthPotion() {
        healedHP = 50;
        sprite = new Rectangle(50, 50);
        sprite.setFill(Color.PURPLE);
    }
    public HealthPotion(double x, double y) {
        healedHP = 50;
        setIcon(new Rectangle(50, 50));
        this.x = x;
        this.y = y;
    }
    public void applyEffect(Player player) {
        if (player.getHealth() < player.getMaxHP()) {
            player.setHealth(player.getHealth() + healedHP);
        }
    }
    public String getName() {
        return "Health Potion";
    }
}
