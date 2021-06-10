package model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Werewolf extends Monster {

    private int xPosition;
    private int yPosition;
    private int speed;
    public Werewolf(int health) {
        super(health);
        xPosition = 100;
        yPosition = 100;
        Shape icon = new Circle(xPosition, yPosition, 20);
        icon.setFill(javafx.scene.paint.Color.RED);
        setIcon(icon);
    }
    //    @Override
    //    public int attack() {
    //        return 0;
    //    }

    public void move(int dx, int dy) {
        setX(((this.getX() + dx * getSpeed()) % getMaxWidth()));
        setY(((this.getY() + getMaxHeight() + dy * getSpeed()) % getMaxHeight()));
        ((Circle) getIcon()).setCenterX(this.getX());
        ((Circle) getIcon()).setCenterY(this.getY());
    }
}
