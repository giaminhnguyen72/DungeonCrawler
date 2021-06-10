
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Shape;

/**
 *
 * @author nguye_000
 */
public abstract class Potion implements Useable {
    private double x;
    private double y;
    private Shape sprite;
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
        getIcon().setLayoutX(x);
        getIcon().setLayoutY(y);
    }
    public abstract void applyEffect(Player player);
    public void use(Player player) {
        applyEffect(player);
    }
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the sprite
     */
    @Override
    public Shape getIcon() {
        return sprite;
    }

    /**
     * @param sprite the sprite to set
     */
    public void setIcon(Shape sprite) {
        this.sprite = sprite;
    }
    
}
