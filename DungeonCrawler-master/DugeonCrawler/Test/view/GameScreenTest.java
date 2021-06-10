package view;


import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jchen844
 */
public class GameScreenTest extends ApplicationTest {
    public GameScreenTest() {

    }
    @Test
    public void testHeight() {
        GameScreen screen = new GameScreen(500, 500);
        int height = screen.getHeight();
        assertEquals(height, 500);
    }
    @Test
    public void testWidth() {
        GameScreen screen = new GameScreen(500, 500);
        int width = screen.getWidth();
        assertEquals(width, 500);
    }
    @Test
    public void testLargeHeight() {
        GameScreen screen = new GameScreen(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int height = screen.getHeight();
        assertEquals(height, Integer.MAX_VALUE);
    }
    @Test
    public void testLargeWidth() {
        GameScreen screen = new GameScreen(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int width = screen.getWidth();
        assertEquals(width, Integer.MAX_VALUE);
    }
    @Test
    public void testCongratsScreenCongrats() {
        FxRobot fxRobot = new FxRobot();
        try {
            FxToolkit.registerPrimaryStage();
        } catch (TimeoutException ex) {
            Logger.getLogger(LossScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRobot.interact(() -> {
            CongratsScreen screen = new CongratsScreen(10, 11, 12);
            System.out.println(screen.getCongrats().toString());
            assertEquals(screen.getCongrats().getText().toString(),
                    "Congrats you escaped and won the game");
        });

    }
    @Test
    public void testCongratsScreenStats() {
        FxRobot fxRobot = new FxRobot();
        try {
            FxToolkit.registerPrimaryStage();
        } catch (TimeoutException ex) {
            Logger.getLogger(LossScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRobot.interact(() -> {
            CongratsScreen s = new CongratsScreen(10, 11, 12);
            assertEquals(s.getStats().getText().toString(),
                    "Damage Dealt: 10\nTotal Hits: 11\nTotal Attacks: 12");
        });
    }
    @Test
    public void testLossScreenTexts() {
        FxRobot fxRobot = new FxRobot();
        try {
            FxToolkit.registerPrimaryStage();
        } catch (TimeoutException ex) {
            Logger.getLogger(LossScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRobot.interact(() -> {
            LossScreen screen = new LossScreen();
            assertEquals(screen.getText().getText().toString(), "Better luck next time!");
        });

    }
    @Test
    public void testLossScreenStats() {
        FxRobot fxRobot = new FxRobot();
        try {
            FxToolkit.registerPrimaryStage();
        } catch (TimeoutException ex) {
            Logger.getLogger(LossScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        fxRobot.interact(() -> {
            LossScreen s = new LossScreen(10, 11, 12);
            assertEquals(s.getStats().getText().toString(),
                    "Damage Dealt: 10\nTotal Hits: 11\nTotal Attacks: 12");
        });

    }
}