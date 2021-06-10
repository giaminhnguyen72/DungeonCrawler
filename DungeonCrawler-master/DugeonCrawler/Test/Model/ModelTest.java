package Model;


import model.Model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 * Author : hzhuarry
 */
public class ModelTest {
    @Test
    public void testIncreaseMoney1() {
        Model model = new Model();
        model.setMoney(100);
        model.increaseMoney(50);
        assertEquals(model.getMoney(), 150);
    }
    @Test
    public void testIncreaseMoney2() {
        Model model = new Model();
        model.setMoney(100);
        model.increaseMoney(-50);
        assertEquals(model.getMoney(), 50);
    }
    //    @Test
    //    public void testMove() {
    //        Model model = new Model();
    //        Player player = model.getPlayer();
    //        int x = player.getX();
    //        int y = player.getY();
    //        int speed = player.getSpeed();
    //        player.move(2, 2);
    //        // 500 + maxWidth (1616) + (2 * 30) % maxWidth = 560
    //        // 500 + maxHeight (876) + (2 * 30) % maxHeight = 560
    //        assertEquals((500 + player.getMaxWidth()
    //                + (2 * speed)) % player.getMaxWidth(), player.getX());
    //        assertEquals((500 + player.getMaxHeight()
    //                + (2 * speed)) % player.getMaxHeight(), player.getY());
    //    }
    //    @Test
    //    public void testMove2() {
    //        Model model = new Model();
    //        Player player = model.getPlayer();
    //        int x = player.getX();
    //        int y = player.getY();
    //        int speed = player.getSpeed();
    //        player.move(30, 50);
    //        // 500 + maxWidth (1616) + (30 * 30) % maxWidth = 1400
    //        // 500 + maxHeight (876) + (50 * 30) % maxHeight = 248
    //        assertEquals((500 + player.getMaxWidth()
    //                + (30 * speed)) % player.getMaxWidth(), player.getX());
    //        assertEquals((500 + player.getMaxHeight()
    //                + (50 * speed)) % player.getMaxHeight(), player.getY());
    //
    //    }
}
