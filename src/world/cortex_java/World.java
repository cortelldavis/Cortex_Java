/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.cortex_java;

import cortex_java.Direction;
import java.util.ArrayList;

/**
 *
 * @author agent
 */
public class World {

    ArrayList<WorldListener> worldListeners;
    ArrayList<WorldObject> worldObjects;

    public World() {
        worldListeners = new ArrayList<WorldListener>();
        worldObjects = new ArrayList<WorldObject>();
    }

    public void addWorldListener(WorldListener wl) {
        worldListeners.add(wl);
    }

    public void worldHasChanged() {

        for (WorldListener listener : worldListeners) {
            listener.onWorldEvent(new WorldEvent());
        }
    }

    public void createWorldObject() {

        WorldObject worldObject = new WorldObject();
        worldObject.setSize(0, 0, 32, 32);
        worldObject.setPosition(100, 100);
        worldObject.setTexture("img.png", 0, 0, 32, 32);
        worldObject.setCollidable(true);
        worldObjects.add(worldObject);

    }

    public WorldObject getWorldObject() {
        return worldObjects.get(0);
    }

    public void moveWorldObject(Direction dir) {
        //left x-size
        //right x+size
        //up 

        switch (dir) {
            case UP:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition()), (int) (worldObjects.get(0).getYPosition() - worldObjects.get(0).getHeight()));
                break;
            case DOWN:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition()), (int) (worldObjects.get(0).getYPosition() + worldObjects.get(0).getHeight()));
                break;
            case LEFT:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition() - worldObjects.get(0).getWidth()), (int) (worldObjects.get(0).getYPosition()));
                break;
            case RIGHT:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition() + worldObjects.get(0).getWidth()), (int) (worldObjects.get(0).getYPosition()));
                break;
        }

    }
}
