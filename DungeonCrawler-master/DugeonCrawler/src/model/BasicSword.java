/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Rectangle;


/**
 *
 * @author nguye_000
 */
public class BasicSword extends Weapon {
    private int damage;
    public BasicSword(int xPos, int yPos, int maxWidth, int maxHeight) {
        
        super(xPos, yPos, 200, maxWidth, maxHeight);
        damage = 50;
        setIcon(new Rectangle(xPos, yPos, 10, 100));
        setAttackDamage(damage);
        addRotate();
    }

    @Override
    public void move(int x, int y) {
        Rectangle icon = (Rectangle) getIcon();
        this.setX((int) x);
        this.setY((int) y);
        icon.setX(this.getX());
        icon.setY(this.getY());
    }

    @Override
    public String getName() {
        return "Basic Sword";
    }
}
