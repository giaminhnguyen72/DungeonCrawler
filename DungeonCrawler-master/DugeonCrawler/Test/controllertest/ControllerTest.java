package controllertest;

import controller.Controller;
import javafx.stage.Stage;
import model.Model;
import model.Player;
import model.Room;
import model.SpeedPotion;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.*;
import org.testfx.api.FxAssert;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.matcher.base.WindowMatchers;

public class ControllerTest extends ApplicationTest {
    private Controller controller;
    private Stage stage;
    public void start(Stage primaryStage) throws Exception {
        controller = new Controller();
        stage = primaryStage;
        controller.start(primaryStage);
    }

    @Test
    public void testNext() {
        clickOn("Play");
        verifyThat("Next", NodeMatchers.isNotNull());
    }

    @Test
    public void testConfigureScreenQuit() {
        clickOn("Play");
        verifyThat("Quit", NodeMatchers.isNotNull());
    }

    @Test
    public void testYMovePlayer() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        Player player = model.getPlayer();
        int speed = player.getSpeed();
        // up
        model.movePlayer(0, -1);
        assertEquals((500 + player.getMaxHeight()
                + (-1 * speed)) % player.getMaxHeight(), player.getY());
        // down
        model.movePlayer(0, 1);
        assertEquals(500, player.getY());
    }

    @Test
    public void testXMovePlayer() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        Player player = model.getPlayer();
        int speed = player.getSpeed();
        // left
        model.movePlayer(-1, 0);
        assertEquals((500 + player.getMaxWidth()
                + (-1 * speed)) % player.getMaxWidth(), player.getX());
        // right
        model.movePlayer(1, 0);
        assertEquals(500, player.getX());
    }

    @Test
    public void testStartingScreen() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        Player player = model.getPlayer();
        verifyThat("StartingScreen", NodeMatchers.isNotNull());
    }

    @Test
    public void testRoomDimensions() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        int min = 5;
        int max = 20;
        int size = (int) (Math.random() * (min - max + 1) + min);
        model.makeMaze(20);
        Room[][] arr = model.getMazeArray();
        int dimWidth = arr.length;
        int dimHeight = arr[0].length;
        assertEquals(dimHeight, dimWidth);
    }

    @Test
    public void testInitialX() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        Player player = model.getPlayer();
        Room[][] mazeArray = model.getMazeArray();
        int mazesize = mazeArray.length;

        int speed = player.getSpeed();

        System.out.println(player.getCurrRoom());
        assertEquals(10, model.getRoomXIndex());
    }

    @Test
    public void testInitialY() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        Player player = model.getPlayer();
        Room[][] mazeArray = model.getMazeArray();
        int mazesize = mazeArray.length;

        int speed = player.getSpeed();

        System.out.println(player.getCurrRoom());
        assertEquals(10, model.getRoomYIndex());
    }

    @Test
    public void testMazeArrayXLength() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        model.makeMaze(20);
        assertEquals(20, model.getMazeArray().length);
    }

    @Test
    public void testMazeArrayYLength() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        model.makeMaze(20);
        assertEquals(20, model.getMazeArray()[0].length);
    }
    @Test
    public void testStartingRoom() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        model.makeMaze(20);
        assertEquals(0, model.getMazeArray()[10][10].getMonsterList().size());
    }
    @Test
    public void testRoom() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        model.makeMaze(20);
        assertEquals(1, model.getMazeArray()[9][10].getMonsterList().size());
    }
    @Test
    public void testVisited() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        assertTrue(model.getMazeArray()[10][10].isVisited());
    }
    @Test
    public void testVisited2() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        model.makeMaze(20);
        assertFalse(model.getMazeArray()[11][10].isVisited());
    }

    @Test
    public void testPlayerHealthDisplayed() {
        clickOn("Test");
        verifyThat("0 Hp: 100", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonsterExitRoom() throws Exception {
        clickOn("Test");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        model.makeMaze(20);
        assertEquals(0, model.getMazeArray()[19][19].getMonsterList().size());
    }
    @Test
    public void testHealing() {
        clickOn("Test");
        clickOn("check inventory");
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        player.setHealth(20);
        clickOn("Health Potion");
        assertEquals(player.getHealth(), 70);
    }
    @Test
    public void testResume() {
        clickOn("Test");
        clickOn("check inventory");
        clickOn("Resume");
        FxAssert.verifyThat(window("Dungeon Crawler"), WindowMatchers.isShowing());
    }
    @Test
    public void testSpeed() {
        Model model = controller.getGameModel();
        Player player = model.getPlayer();
        int speed = player.getSpeed();
        player.getInventory().addItem(new SpeedPotion(100, 100));
        clickOn("Test");
        clickOn("check inventory");
        clickOn("Speed Potion");
        assertEquals(player.getSpeed(), speed * 2);
    }

    @Test
    public void testWeaponSelection() {
        clickOn("Test");
        clickOn("check inventory");
        assertNotNull("BasicSword");
    }
}
