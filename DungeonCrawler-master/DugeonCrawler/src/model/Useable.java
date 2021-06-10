/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.shape.Shape;

/**
 *
 * @author nguye_000
 */
public interface Useable {
    void use(Player user);
    Shape getIcon();
    String getName();
}
