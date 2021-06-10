/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.BasicSword;
import model.Inventory;
import model.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author nguye_000
 */
public class InventoryScreenTest extends ApplicationTest {
    
    public InventoryScreenTest() {
    }

    
    @Test
    public void testInventoryScreenInit() {
        InventoryScreen screen = new InventoryScreen(new Inventory(
                new BasicSword(100, 100, 100, 200), new Player()),
                100, 100);
        screen.getScene();
        assertNotNull(screen.getInventory());
        assertNotNull(screen.getWeaponGroup());
    }

    /**
     * Test of getResumeButton method, of class InventoryScreen.
     */
    @Test
    public void testGetResumeButton() {
    }

    /**
     * Test of getPotionGroup method, of class InventoryScreen.
     */
    @Test
    public void testGetPotionGroup() {
    }

    /**
     * Test of getWeaponGroup method, of class InventoryScreen.
     */
    @Test
    public void testGetWeaponGroup() {
    }

    /**
     * Test of getInventory method, of class InventoryScreen.
     */
    @Test
    public void testGetInventory() {
    }

    /**
     * Test of addButtonListener method, of class InventoryScreen.
     */
    @Test
    public void testAddButtonListener() {
        
    }

    /**
     * Test of addChangeListener method, of class InventoryScreen.
     */
    @Test
    public void testAddChangeListener() {
    }
    
}
