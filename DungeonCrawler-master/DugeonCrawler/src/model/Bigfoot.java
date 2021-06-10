package model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Bigfoot extends Monster {
    private Shape sprite;
    private final int defaultHP = 200;
    public Bigfoot() {
        super();
        sprite = new Rectangle(100, 100, 100, 100);
        sprite.setFill(javafx.scene.paint.Color.RED);
        setHealth(defaultHP);
        setIcon(sprite);
    }

    public Bigfoot(int health) {
        super();
        sprite = new Rectangle(200, 200, 100, 100);
        sprite.setFill(javafx.scene.paint.Color.GREEN);
        setHealth(health);
        setIcon(sprite);
    }

    //    @Override
    //    public int attack() {
    //        return 1;
    //    }
    @Override
    public void move(int dx, int dy) {
        setX(((this.getX() + getMaxWidth() + dx * getSpeed()) % getMaxWidth()));
        setY(((this.getY() + getMaxHeight() + dy * getSpeed()) % getMaxHeight()));
        ((Rectangle) getIcon()).setX(this.getX());
        ((Rectangle) getIcon()).setY(this.getY());
    }
}
