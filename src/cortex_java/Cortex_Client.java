
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
        Renderer r = new Renderer();
        View vw = new View();
        vw.setDisplayImage(r.getCompositeRender());

        Controller control = new Controller();
        System.out.println("no keys pressed");

        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(control);

        world.createWorld();
        r.setWorld(world);
        vw.updateDisplay();

        
       
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
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cortex_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
