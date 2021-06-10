package model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Dragon extends Monster {
    private Shape sprite;
    private final int defaultHP = 100;
    public Dragon() {
        super(100);
        sprite = new Rectangle(100, 100, 100, 100);
        setX(100);
        setY(100);
        setHealth(defaultHP);
        setIcon(sprite);
        sprite.setFill(javafx.scene.paint.Color.BLUE);
    }

    public Dragon(int health) {
        super();
        sprite = new Rectangle(100, 100, 100, 100);
        sprite.setFill(javafx.scene.paint.Color.BLUE);
        setHealth(defaultHP);
        setIcon(sprite);

    }
    @Override
    public void move(int dx, int dy) {
        setX(((this.getX() + getMaxWidth() + dx * getSpeed()) % getMaxWidth()));
        setY(((this.getY() + getMaxHeight() + dy * getSpeed()) % getMaxHeight()));
        ((Rectangle) getIcon()).setX(this.getX());
        ((Rectangle) getIcon()).setY(this.getY());
    }
    //    @Override
    //    public int attack() {
    //        return 2;
    //    }
}
