/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import static javafx.scene.transform.Transform.rotate;

/**
 *
 * @author nguye_000
 */
public abstract class Weapon {
    private int attackDamage;
    private Shape icon;
    private int x;
    private int y;
    private int width;
    private int height;
    private int maxX;
    private int maxY;
    private Rotate rotate;
    private String name;
    private boolean effect;
    public Weapon(int xPos, int yPos, int width, int height) {
        x = xPos;
        y = yPos;
        this.width = width;
        this.height = height;
        effect = false;
    }
    public Weapon(int xPos, int yPos, int width, int height, int maxWidth, int maxHeight) {
        x = xPos;
        y = yPos;
        this.width = width;
        this.height = height;
        maxX = maxWidth;
        maxY = maxHeight;
        effect = false;
    }
    public Weapon(int xPos, int yPos, int radius, int maxWidth, int maxHeight) {
        x = xPos;
        y = yPos;
        this.width = radius;
        maxX = maxWidth;
        maxY = maxHeight;
        effect = false;
    }
    public void addRotate() {
        rotate = new Rotate();
        rotate.setPivotX(x);
        rotate.setPivotY(y);
        rotate.setAngle(0);
        getIcon().getTransforms().add(rotate);
    }
    /**
     * @return the attackDamage
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * @param attackDamage the attackDamage to set
     */
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     * @return the icon
     */
    public Shape getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Shape icon) {
        this.icon = icon;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    public abstract void move(int dx, int dy);

    /**
     * @return the maxX
     */
    public int getMaxX() {
        return maxX;
    }

    /**
     * @param maxX the maxX to set
     */
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    /**
     * @return the maxY
     */
    public int getMaxY() {
        return maxY;
    }

    /**
     * @param maxY the maxY to set
     */
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
    public void rotate(int angle) {
        Shape icon = getIcon();
        rotate.setPivotX(x);
        rotate.setPivotY(y);
        rotate.setAngle(angle);
    }

    /**
     * @return the name of the weapon
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the effect
     */
    public boolean isEffect() {
        return effect;
    }

    /**
     * @param effect the effect to set
     */
    public void setEffect(boolean effect) {
        this.effect = effect;
    }
}
