/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agent
 */
package cortex_java;

public interface WorldListener {
    public void onWorldEvent(WorldEvent e);
    public void listenToWorld(World world);
    
}
