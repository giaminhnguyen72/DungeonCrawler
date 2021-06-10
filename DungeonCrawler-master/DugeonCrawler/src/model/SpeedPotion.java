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
public class SpeedPotion extends Potion {
    private int healedHP;
    private Shape sprite;
    private double x;
    private double y;
    public SpeedPotion() {
        healedHP = 50;
        sprite = new Rectangle(10, 10, 10, 10);
        sprite.setFill(Color.YELLOW);
    }
    public SpeedPotion(double x, double y) {
        healedHP = 50;
        setIcon(new Rectangle(20, 20));
        this.x = x;
        this.y = y;
    }
    public void applyEffect(Player player) {
        player.setSpeed(player.getSpeed() * 2);
    }
    public String getName() {
        return "Speed Potion";
    }
}
