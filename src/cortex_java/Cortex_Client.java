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

        for (int count = 1; count <= 2; count++) {
            System.out.println("object has been created in the world:\nID: " + world.getWorldObjectById(count).getId());
            System.out.println("name: " + ((Actor) world.getWorldObjectById(count)).getActor_Name());
            System.out.println("level: " + ((Actor) world.getWorldObjectById(count)).getLevel());
            System.out.println("health: " + ((Actor) world.getWorldObjectById(count)).getHealth());
            System.out.println("agility: " + ((Actor) world.getWorldObjectById(count)).getAgility());
            System.out.println("strength: " + ((Actor) world.getWorldObjectById(count)).getStrength());
            System.out.println("willpower: " + ((Actor) world.getWorldObjectById(count)).getWillpower());
        }

        while (running) {

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cortex_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
