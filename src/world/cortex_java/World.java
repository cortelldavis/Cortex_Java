/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.cortex_java;

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

        worldObjects.add(new WorldObject());

    }

    public WorldObject getWorldObject() {
        return worldObjects.get(0);
    }
}
