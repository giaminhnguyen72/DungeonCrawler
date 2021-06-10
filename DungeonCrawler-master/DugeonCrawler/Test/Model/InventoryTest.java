/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nguye_000
 */
public class InventoryTest {
    
    public InventoryTest() {
    }
    @Test
    public void testInitialization() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        assertEquals(inventory.getWeapons().size(), 1);
        assertEquals(inventory.getItems().size(), 1);
    }
    /**
     * Test of addWeapon method, of class Inventory.
     */
    @Test
    public void testAddWeapon() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        inventory.addWeapon(new LightSaber(0, 0, 100, 100));
        assertEquals(inventory.getWeapons().size(), 2);
        assertEquals(inventory.getItems().size(), 1);
        
    }

    @Test
    public void testAttackPotion() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        AttackPotion potion = new AttackPotion(50, 50);
        inventory.addItem(potion);
        potion.applyEffect(player);
        assertEquals(100, player.getWeapon().getAttackDamage());
    }

    /**
     * Test of addItem method, of class Inventory.
     */
    @Test
    public void testAddItem() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        inventory.addItem(new HealthPotion());
        assertEquals(2, inventory.getItems().size());
        assertEquals(1, inventory.getWeapons().size());
    }

    /**
     * Test of getWeapons method, of class Inventory.
     */
    @Test
    public void testGetWeapons() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        assertNotNull(inventory.getWeapons());
        assertEquals(1, inventory.getWeapons().size());
    }

    /**
     * Test of getItems method, of class Inventory.
     */
    @Test
    public void testGetItems() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        assertNotNull(inventory.getItems());
        assertEquals(1, inventory.getItems().size());
        assertTrue(inventory.getItems().get(0) instanceof HealthPotion);
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void testRemoveItemUseable() {
        Player player = new Player();
        Inventory inventory = new Inventory(player.getWeapon(), player);
        inventory.removeItem(0);
        assertEquals(0, inventory.getItems().size());
    }

    /**
     * Test of removeItem method, of class Inventory.
     */
    @Test
    public void testRemoveItemInt() {
    }

    /**
     * Test of setWeapons method, of class Inventory.
     */
    @Test
    public void testSetWeapons() {
    }

    /**
     * Test of setItems method, of class Inventory.
     */
    @Test
    public void testSetItems() {
    }

    /**
     * Test of getPlayer method, of class Inventory.
     */
    @Test
    public void testGetPlayer() {
    }

    /**
     * Test of setPlayer method, of class Inventory.
     */
    @Test
    public void testSetPlayer() {
    }
    
}
