/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package world;

import dragonfall.Direction;
import dragonfall.Texture;
import java.awt.*;

/**
 *
 * @author cortell davis
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
    //direction stores where an world object is facing in a north,west,south, or east format
    Direction direction;
    //animated_state is used to keep track of world objects animated stated for animating it
    int animated_state;
    //id is a unique number that categorizes all world objects in the game
    int id;

    public WorldObject() {
        //contructor initialises all of the properties of the world object
        position = new Point();
        size = new Rectangle();
        collidable = false;
        texture = new Texture();
        animated_state = 1;
        direction = direction.NORTH;
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

    public Direction getDirection() {
        return direction;
    }

    public int getAnimated_state() {
        return animated_state;
    }

    public int getId() {
        return id;
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

    public void setPosition(int x, int y) {
        position.setLocation(x, y);
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

    public void setTexture(String filename, int source_x1, int source_y1, int source_x2, int source_y2, int frame_x1, int frame_y1, int frame_x2, int frame_y2) {
        texture.setTextureAddress(filename);
        texture.setTextureSource_x1(source_x1);
        texture.setTextureSource_y1(source_y1);
        texture.setTextureSource_x2(source_x2);
        texture.setTextureSource_y2(source_y2);
        texture.setTextureFrame_x1(frame_x1);
        texture.setTextureFrame_y1(frame_y1);
        texture.setTextureFrame_x2(frame_x2);
        texture.setTextureFrame_y2(frame_y2);
    }

    public void setTextureFrame(int x1, int y1, int x2, int y2) {
        texture.setTextureFrame_x1(x1);
        texture.setTextureFrame_y1(y1);
        texture.setTextureFrame_x2(x2);
        texture.setTextureFrame_y2(y2);
    }

    public void setDirection(Direction dir) {
        direction = dir;
    }

    public void setAnimated_state(int animated_state) {
        this.animated_state = animated_state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void animate() {
        switch (direction) {
            case NORTH:

                if (getAnimated_state() == 1) {
                    setTextureFrame(0, 96, 32, 32);
                    setAnimated_state(2);
                    break;
                }
                if (getAnimated_state() == 2) {
                    setTextureFrame(32, 96, 32, 32);
                    setAnimated_state(3);
                    break;
                }
                if (getAnimated_state() == 3) {
                    setTextureFrame(64, 96, 32, 32);
                    setAnimated_state(1);
                    break;
                }

                break;
            case SOUTH:

                if (getAnimated_state() == 1) {
                    setTextureFrame(0, 0, 32, 32);
                    setAnimated_state(2);
                    break;
                }
                if (getAnimated_state() == 2) {
                    setTextureFrame(32, 0, 32, 32);
                    setAnimated_state(3);
                    break;
                }
                if (getAnimated_state() == 3) {
                    setTextureFrame(64, 0, 32, 32);
                    setAnimated_state(1);
                    break;
                }

                break;
            case WEST:

                if (getAnimated_state() == 1) {
                    setTextureFrame(0, 32, 32, 32);
                    setAnimated_state(2);
                    break;

                }
                if (getAnimated_state() == 2) {
                    setTextureFrame(32, 32, 32, 32);
                    setAnimated_state(3);
                    break;

                }
                if (getAnimated_state() == 3) {
                    setTextureFrame(64, 32, 32, 32);
                    setAnimated_state(1);
                    break;

                }

                break;
            case EAST:

                if (getAnimated_state() == 1) {
                    setTextureFrame(0, 64, 32, 32);
                    setAnimated_state(2);
                    break;

                }
                if (getAnimated_state() == 2) {
                    setTextureFrame(32, 64, 32, 32);
                    setAnimated_state(3);
                    break;

                }
                if (getAnimated_state() == 3) {
                    setTextureFrame(64, 64, 32, 32);
                    setAnimated_state(1);
                    break;

                }
                break;
        }
    }

    public void move() {
        switch (direction) {
            case NORTH:
                setPosition((int) (getXPosition()), (int) (getYPosition() - getHeight() / 2));

                animate();

                break;
            case SOUTH:
                setPosition((int) (getXPosition()), (int) (getYPosition() + getHeight() / 2));

                animate();

                break;
            case WEST:
                setPosition((int) (getXPosition() - getWidth() / 2), (int) (getYPosition()));
                animate();

                break;
            case EAST:
                setPosition((int) (getXPosition() + getWidth() / 2), (int) (getYPosition()));
                animate();
                break;
        }

    }
}
