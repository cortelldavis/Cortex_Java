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

        worldObjects.get(0).move();
        worldHasChanged();
    }
}
