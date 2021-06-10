package Model;

import model.Bigfoot;
import model.Dragon;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonsterTest {

    @Test
    public void testDragonInit() {
        Dragon dragon = new Dragon(100);
        assertEquals(dragon.getHealth(), 100);
    }

    @Test
    public void testDragonMove() {
        Dragon dragon = new Dragon(100);
        dragon.setX(0);
        dragon.setY(0);
        dragon.move(1, 2);
        assertEquals(dragon.getX(), 1);
        assertEquals(dragon.getY(), 2);
    }

    @Test
    public void testBigfootInit() {
        Bigfoot bigfoot = new Bigfoot(100);
        assertEquals(bigfoot.getHealth(), 100);
    }

    @Test
    public void testBigfootMove() {
        Bigfoot bigfoot = new Bigfoot(100);
        bigfoot.setX(0);
        bigfoot.setY(0);
        bigfoot.move(1, 2);
        assertEquals(bigfoot.getX(), 1);
        assertEquals(bigfoot.getY(), 2);
    }

}
