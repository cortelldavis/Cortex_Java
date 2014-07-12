
package world;

import cortex_java.ResourceLoader;
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
        createWorldObject("World Object ID");
        worldHasChanged();
    }

    public void createWorldObject(String id) {

        WorldObject worldObject = ResourceLoader.getWorldObjectById(id);
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
