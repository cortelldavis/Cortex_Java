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

    ArrayList<WorldListener> listeners;

    public World() {
        listeners = new ArrayList<WorldListener>();
    }

    public void addWorldListener(WorldListener wl) {
        listeners.add(wl);
    }

    public void worldChanged() {
       
        for(WorldListener listener:listeners)
        listener.onWorldEvent(new WorldEvent());
    }
}
