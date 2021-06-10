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
public class AttackPotion extends Potion {

    public AttackPotion(int x, int y) {
        setIcon(new Rectangle(50, 50));
        getIcon().setFill(Color.PURPLE);
        setX(x);
        setY(y); 
    }

    @Override
    public void applyEffect(Player player) {
        player.getWeapon().setAttackDamage(player.getWeapon().getAttackDamage() * 2);
    }

    @Override
    public String getName() {
        return "Attack Potion";
    }
    
    
}
