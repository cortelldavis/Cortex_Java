/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import cortex_java.Direction;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author cortell davis
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

    public void createWorld() {
        System.out.println("World: new world has been created");
        createWorldObject();
        worldHasChanged();
    }

    public void createWorldObject() {

        WorldObject worldObject = new WorldObject();
        worldObject.setSize(0, 0, 32, 32);
        worldObject.setPosition(100, 100);
        worldObject.setTexture("../res/images/spritesheet_1.png", 0, 0, 96, 128, 0, 0, 32, 32);
        worldObject.setCollidable(true);
        worldObjects.add(worldObject);
        worldHasChanged();

    }

    public WorldObject getWorldObject() {
        return worldObjects.get(0);
    }

    public void moveWorldObject() {

        //left x-size
        //right x+size
        //up 
        Direction dir = worldObjects.get(0).getDirection();

        switch (dir) {
            case NORTH:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition()), (int) (worldObjects.get(0).getYPosition() - worldObjects.get(0).getHeight()));
                 worldObjects.get(0).setTextureFrame(0, 96, 32, 32);

                break;
            case SOUTH:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition()), (int) (worldObjects.get(0).getYPosition() + worldObjects.get(0).getHeight()));
                 worldObjects.get(0).setTextureFrame(0, 0, 32, 32);
                break;
            case WEST:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition() - worldObjects.get(0).getWidth()), (int) (worldObjects.get(0).getYPosition()));
                  worldObjects.get(0).setTextureFrame(0, 32, 32, 32);
                break;
            case EAST:
                worldObjects.get(0).setPosition((int) (worldObjects.get(0).getXPosition() + worldObjects.get(0).getWidth()), (int) (worldObjects.get(0).getYPosition()));
                  worldObjects.get(0).setTextureFrame(0, 64, 32, 32);
                break;
        }
        worldHasChanged();
    }
}
