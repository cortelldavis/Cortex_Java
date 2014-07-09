/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Cortex_Client {

    private static boolean running = true;

    public static void main(String args[]) throws InterruptedException {
        Renderer r = new Renderer();
        View vw = new View();
        vw.setDisplayImage(r.getCompositeRender());
        World world = new World();

        Controller control = new Controller();
        System.out.println("no keys pressed");

        //if key has been pressed, print the key that was pressed
        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(control);

        //add world listener to the renderer
        r.setWorld(world);

        world.createWorldObject();

        while (running) {

            if (control.isKeyPressed()) {

                if (control.getCommand() == Command.UP) {
                    world.getWorldObject().setDirection(Direction.NORTH);
                }
                if (control.getCommand() == Command.LEFT) {
                    world.getWorldObject().setDirection(Direction.WEST);
                }
                if (control.getCommand() == Command.DOWN) {
                    world.getWorldObject().setDirection(Direction.SOUTH);
                }
                if (control.getCommand() == Command.RIGHT) {
                    world.getWorldObject().setDirection(Direction.EAST);
                }

                world.moveWorldObject();
                vw.updateDisplay();

                control.setKeyPressed(false);
            }
            Thread.sleep(30);
        }

    }
}
