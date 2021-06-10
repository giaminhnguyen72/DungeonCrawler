package view;

import controller.Controller;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;

import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;

/**
 *
 * @author jchen844
 */
public class ConfigurationScreenTest extends ApplicationTest {
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller();
        controller.start(primaryStage);
    }
    public ConfigurationScreenTest() {

    }
    @Test
    public void testLargeHeight() {
        ConfigurationScreen screen = new ConfigurationScreen(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int height = screen.getHeight();
        assertEquals(height, Integer.MAX_VALUE);
    }
    @Test
    public void testLargeWidth() {
        ConfigurationScreen screen = new ConfigurationScreen(Integer.MAX_VALUE, Integer.MAX_VALUE);
        int width = screen.getWidth();
        assertEquals(width, Integer.MAX_VALUE);
    }
    @Test
    public void testTitle() {
        FxAssert.verifyThat(window("Dungeon Crawler"), WindowMatchers.isShowing());
    }
    @Test
    public void testConfigTitle() {
        clickOn("Play");
        FxAssert.verifyThat(window("Dungeon Crawler"), WindowMatchers.isShowing());
    }
    @Test
    public void testHeight() {
        ConfigurationScreen screen = new ConfigurationScreen(1000, 500);
        int height = screen.getHeight();
        assertEquals(height, 500);
    }
    @Test
    public void testWidth() {
        ConfigurationScreen screen = new ConfigurationScreen(1000, 500);
        int width = screen.getWidth();
        assertEquals(width, 1000);
    }   
}
