/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;


/**
 *
 * @author nguye_000
 */
public class AttackHandler {
    public boolean checkWeaponCollision(Weapon weapon, Room room) {
        boolean returned = false;
        ArrayList<Monster> list = room.getMonsterList();
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                Monster mons = list.get(i);
                if (weapon.getIcon().getBoundsInParent()
                        .intersects(mons.getIcon().getBoundsInParent())) {
                    mons.beAttacked(weapon.getAttackDamage());
                    returned = true;
                    if (mons.getHealth() <= 0) {
                        room.removeMonster(mons);
                    }
                    
                }
            }
            return returned;
        } else {
            return returned;
        }
        
    }
}
