/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.cortex_java;

import cortex_java.Texture;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author agent
 */
public class WorldObject {

    //position stores coordinates in x,y format
    Point position;
    //size stores bounding information related to the size of the world object in the x1,y1,x2,y2 format
    Rectangle size;
    //collidable is a flag used for collision detection
    boolean collidable;
    //texture stores a filename and the x1,x2,y1,y2 source information about a bitmap that represents the world object 
    Texture texture;

    public boolean isCollidable() {
        return collidable;
    }

    public void setCollidable(boolean arg) {
        collidable = arg;
    }

    public Rectangle getSize() {
        return size;
    }

    public double getWidth() {
        return size.getWidth();
    }

    public double getHeight() {
        return size.getHeight();
    }

    public Point getPosition() {
        return position;
    }

    public int getXPosition() {
        return position.x;
    }

    public int getYPosition() {
        return position.y;
    }

    public Rectangle setSize() {
        return size;
    }

    public double setWidth() {
        return size.getWidth();
    }

    public double setHeight() {
        return size.getHeight();
    }

    public Point setPosition() {
        return position;
    }

    public int setXPosition() {
        return position.x;
    }

    public int setYPosition() {
        return position.y;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture() {
    }
}
