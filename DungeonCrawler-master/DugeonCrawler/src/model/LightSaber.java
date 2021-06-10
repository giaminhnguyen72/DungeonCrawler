/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author nguye_000
 */
public class LightSaber extends Weapon implements Useable {
    private int damage;
    public LightSaber(int xPos, int yPos, int maxWidth, int maxHeight) {

        super(xPos, yPos, 200, maxWidth, maxHeight);
        damage = 50;
        Rectangle icon = new Rectangle(xPos, yPos, 10, 250);
        icon.setFill(Color.BLUE);
        setIcon(icon);
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
        return "Light Saber";
    }

    @Override
    public void use(Player user) {
        throw new UnsupportedOperationException(
                "Not supported yet."); //To change body of generated methods,
                // choose Tools | Templates.
    }
}
