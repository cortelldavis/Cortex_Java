/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import cortex_java.Controller.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import world.World;

/**
 *
 * @author cortell davis
 */
public class Cortex_Client implements Runnable {
    
    private static boolean running = true;
    
    public static void main(String args[]) {
        new Thread(new Cortex_Client(), "Cortex_Client").start();
    }
    
    @Override
    
    public void run() {
        World world = new World();
        world.createWorld();
        Renderer r = new Renderer();
        
        r.setWorld(world);
        View vw = new View();
        vw.setDisplayImage(r.getCompositeRender());
        
        Controller control = new Controller();
        
        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(control);
        
        vw.updateDisplay();
        /*
         for (int count = 1; count <= 3; count++) {
         System.out.println("\nobject has been created in the world:\nID: " + world.getWorldObjectById(count).getId());
         System.out.println("name: " + ((Actor) world.getWorldObjectById(count)).getActor_Name());
         System.out.println("level: " + ((Actor) world.getWorldObjectById(count)).getLevel());
         System.out.println("health: " + ((Actor) world.getWorldObjectById(count)).getHealth());
         System.out.println("agility: " + ((Actor) world.getWorldObjectById(count)).getAgility());
         System.out.println("strength: " + ((Actor) world.getWorldObjectById(count)).getStrength());
         System.out.println("willpower: " + ((Actor) world.getWorldObjectById(count)).getWillpower());
         System.out.println("World Object Properties:");
         System.out.println("\n");
         System.out.println("size x1: " + ((Actor) world.getWorldObjectById(count)).getSize().x);
         System.out.println("size y1: " + ((Actor) world.getWorldObjectById(count)).getSize().y);
         System.out.println("size x2: " + ((Actor) world.getWorldObjectById(count)).getSize().width);
         System.out.println("size y2: " + ((Actor) world.getWorldObjectById(count)).getSize().height);
         System.out.println("\n");
         System.out.println("texture frame y1: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureFrame_y1());
         System.out.println("texture frame x1: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureFrame_x1());
         System.out.println("texture frame y2: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureFrame_y2());
         System.out.println("texture frame x2: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureFrame_x2());
         System.out.println("\n");
         System.out.println("texture source y1: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureSource_y1());
         System.out.println("texture source x1: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureSource_x1());
         System.out.println("texture source y2: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureSource_y2());
         System.out.println("texture source x2: " + ((Actor) world.getWorldObjectById(count)).getTexture().getTextureSource_x2());
         System.out.println("\n");
         System.out.println("position x:" + ((Actor) world.getWorldObjectById(count)).getPosition().x);
         System.out.println("position y:" + ((Actor) world.getWorldObjectById(count)).getPosition().y);
         System.out.println("collidable: " + ((Actor) world.getWorldObjectById(count)).isCollidable());
         System.out.println("\n");
         }
         */

        //   world.getWorldMap().printMap();
        GameState clientState = new GameState() {
            
            @Override
            public void onResume() {
                super.onResume(); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void onExit() {
                super.onExit(); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void onPause() {
                super.onPause(); //To change body of generated methods, choose Tools | Templates.
            }
            
            @Override
            public void onStart() {
                super.onStart(); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        clientState.setState(clientState.START);
        
        while (running) {
            
            //controller
            //clientState
            //CommandStateAdapter
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cortex_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
