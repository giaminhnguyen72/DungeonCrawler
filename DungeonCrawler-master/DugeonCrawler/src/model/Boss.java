/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 *
 * @author nguye_000
 */
public class Boss extends Monster {
    private final int defaultHP = 500;
    private final int minRadius = 10;
    public Boss() {
        super();
        setX(100);
        setY(100);
        Shape icon = new Circle(getX(), getY(), 50);
        icon.setFill(javafx.scene.paint.Color.GREEN);
        setIcon(icon);
        setHealth(defaultHP);

    }
    @Override
    public void move(int dx, int dy) {
        setX(((this.getX() + getMaxWidth() + dx * getSpeed()) % getMaxWidth()));
        setY(((this.getY() + getMaxHeight() + dy * getSpeed()) % getMaxHeight()));
        ((Circle) getIcon()).setCenterX(getX());
        ((Circle) getIcon()).setCenterY(getY());
    }
    public int beAttacked(int attack) {
        Circle circle = (Circle) getIcon();
        if (circle.getRadius() > minRadius) {
            circle.setRadius(circle.getRadius() - 1);
        }
        this.setHealth(getHealth() - attack);
        return getHealth();
    }
}
