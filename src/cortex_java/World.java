/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

/**
 *
 * @author agent
 */
public class World {
    
   static  WorldListener listener;
    
    static void addWorldListener(WorldListener wl) {
        listener = wl;
    }
    
    static void WorldChanged() {
        listener.OnWorldEvent(new WorldEvent());
    }
}
