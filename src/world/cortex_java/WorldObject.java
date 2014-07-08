/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.cortex_java;

import cortex_java.Texture;
import java.awt.*;

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

    public WorldObject() {
        //contructor initialises all of the properties of the world object
        position = new Point();
        size = new Rectangle();
        collidable = false;
        texture = new Texture();
    }

    public boolean isCollidable() {
        return collidable;
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

    public Texture getTexture() {
        return texture;
    }

    public void setCollidable(boolean arg) {
        collidable = arg;
    }

    public void setSize(Rectangle arg) {
        size = arg;
    }

    public void setSize(int i, int i0, int i1, int i2) {
        size.setBounds(new Rectangle(i, i0, i1, i2));
    }

    public void setWidth(int w) {
        size.setSize(w, (int) size.getHeight());
    }

    public void setHeight(int h) {
        size.setSize((int) size.getWidth(), h);
    }

    public void setPosition(int i, int i0) {
        position.setLocation(i, i0);
    }

    public void setPosition(Point p) {
        position = p;
    }

    public void setXPosition(int x) {
        position.setLocation(x, position.getY());
    }

    public void setYPosition(int y) {
        position.setLocation(position.getX(), y);
    }

    public void setTexture(String filename, int y1, int x1, int y2, int x2) {
        texture.setTextureAddress(filename);
        texture.setTextureSource(y1, x1, y2, x2);
    }

}
