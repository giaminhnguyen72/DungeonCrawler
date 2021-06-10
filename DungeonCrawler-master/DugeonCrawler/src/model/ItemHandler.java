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
public class ItemHandler {
    public void checkItemCollision(Player player, Room room) {
        ArrayList<Useable> list = room.getItemList();
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                Useable item = list.get(i);
                if (item.getIcon().getBoundsInParent()
                        .intersects(player.getPlayerChar().getBoundsInParent())) {
                    list.remove(i);
                    room.removeItem(item);
                    if (item instanceof Weapon) {
                        player.getInventory().addWeapon((Weapon) item);
                    } else {
                        player.getInventory().addItem(item);
                    }
                    
                }
       
            }
        } else {
            System.out.println("empty list");
        }
        
    }
}
