package model;



import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import view.LossScreen;

/**
 * Abstract Monster class.
 */
public abstract class Monster {

    private int health;
    private Shape icon;
    private int x = 100;
    private int y = 100;
    private int speed;
    private int maxHeight = 700;
    private int maxWidth = 1300;
    public Monster() {
        this((int) (Math.random() * 100));
    }

    public Monster(int health) {
        health = Math.max(health, 1);
        this.health = health;
        speed = 1;
    }
    public Monster(int health, Shape icon) {
        health = Math.max(health, 1);
        this.icon = icon;
        this.health = health;
    }
    public int checkMonsterCollision(Player player, Stage stage,
                                     int damageDealt, int totalHits, int totalAttacks) {
        //    ArrayList<Monster> list = room.getMonsterList();
        if (getIcon().getBoundsInParent().intersects(player.getPlayerChar().getBoundsInParent())) {
            player.beAttacked(10);
            if (player.getHealth() <= 0) {
                stage.close();
                System.out.println("dead");
                LossScreen lossScreen = new LossScreen(damageDealt, totalHits, totalAttacks);
                return player.getHealth();
            }
        }
        return player.getHealth();

    }

    public boolean isAlive() {
        return health > 0;
    }

    public int beAttacked(int attack) {
        this.setHealth(this.health - attack);
        return this.health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }
    public void setIcon(Shape icon) {
        this.icon = icon;
    }
    public Shape getIcon() {
        return icon;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //    public void setPath() {
    ////        Pane root = new Pane();
    //
    //        Path path = new Path();
    //        path.getElements().add(new MoveTo(40, 240));
    //        path.getElements().add(new CubicCurveTo(360, 120, 500, 340, 840, 480));
    //
    //        Circle circle = new Circle(20, 120, 10);
    //        circle.setFill(Color.CADETBLUE);
    //
    //        PathTransition ptr = new PathTransition();
    //
    //        ptr.setDuration(Duration.seconds(6));
    //        ptr.setDelay(Duration.seconds(2));
    //        ptr.setPath(path);
    //        ptr.setNode(circle);
    //        ptr.setCycleCount(2);
    //        ptr.setAutoReverse(true);
    //        ptr.play();
    //
    //        getPane().getChildren().addAll(path, circle);
    //    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxWidth() {
        return maxWidth;
    }
    public void dropItem() {
        
    }
    abstract void move(int dx, int dy);
}
