/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

import java.util.logging.Level;
import java.util.logging.Logger;
import world.cortex_java.World;

/**
 *
 * @author agent
 */
public class Cortex_Client {
    
    private static boolean running = true;
    
    public static void main(String args[]) throws InterruptedException {
        Renderer r = new Renderer();
        View vw = new View();
        vw.setDisplayImage(r.renderAndGetNewScene());
        World world = new World();
        
        Control control = new Control();
        System.out.println("no keys pressed");

        //if key has been pressed, print the key that was pressed
        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(control);

        //add world listener to the renderer
        r.listenToWorld(world);
        
        world.createWorldObject();
        r.renderWorldObject(world.getWorldObject());
        while (running) {
            
            if (control.isKeyPressed()) {
                
                world.worldHasChanged();
                control.setKeyPressed(false);
            }
            Thread.sleep(1000);
        }
        
    }
}
