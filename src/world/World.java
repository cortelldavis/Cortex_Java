/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package world;

import cortex_java.ResourceLoader;
import cortex_java.WorldMap;
import java.util.ArrayList;

/**
 *
 * @author cortell davis
 */
public class World {

    private ArrayList<WorldListener> worldListeners;
    private ArrayList<WorldObject> worldObjects;
    private WorldMap worldMap;

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
        createWorldObjectById(2);
        createWorldObjectById(1);
        createWorldObjectById(3);
        createWorldMap();
        worldHasChanged();
    }

    public void createWorldObjectById(int id) {

        WorldObject worldObject = ResourceLoader.getWorldObjectById(id);
        worldObjects.add(worldObject);
        worldHasChanged();

    }

    public WorldObject getWorldObjectById(int id) {

        WorldObject targetObject = null;
        for (WorldObject wo : worldObjects) {
            if (id == wo.getId()) {
                targetObject = wo;
            }
        }

        return targetObject;

    }

    public void moveWorldObject() {

        worldObjects.get(0).move();
        worldHasChanged();
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    private void createWorldMap() {
        worldMap = ResourceLoader.getWorldMap();
        worldHasChanged();
    }

}
