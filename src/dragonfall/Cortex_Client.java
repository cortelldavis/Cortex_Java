/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package dragonfall;

import dragonfall.Controller.Command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import world.World;

/**
 *
 * @author cortell davis
 */
public class Cortex_Client implements Runnable {

    private Controller controller;
    private static boolean running;
    private World world;
    private Renderer r;
    private GameState clientState;
    private Adapter adapter;
    private View vw;
    private StartScreen startScreen;

    public static void main(String args[]) {
        new Thread(new Cortex_Client(), "Cortex_Client").start();
    }

    public Cortex_Client() {
        clientState = new GameState() {

            @Override
            public void onResume() {
                super.onResume();
                resume();
            }

            @Override
            public void onExit() {
                super.onExit();
                exit();
            }

            @Override
            public void onPause() {
                super.onPause();
                pause();
            }

            @Override
            public void onStart() {
                super.onStart();
                start();
            }

        };
        world = new World();
        r = new Renderer();
        controller = new Controller();
        adapter = new Adapter();
        vw = new View();
        startScreen = new StartScreen();
    }

    @Override
    public void run() {

        init();

        while (running) {

            adapter.loop();

            if (adapter.isMotionEnabled()) {

                //check for edge of screen if so then move map appropriately
                //world.getWorldMap("src/res/xml/myMap.tmx").setMapX(world.getWorldMap("src/res/xml/myMap.tmx").getMapX()-100);
                adapter.setObjectDirection(world.getWorldObjectById(1));
                world.moveWorldObject(1);
                if (world.getWorldObjectById(1).getYPosition() < 32) {
                    world.getWorldObjectById(1).setYPosition((world.getWorldObjectById(1).getYPosition()+16));
                    world.getWorldMap("src/res/xml/mu1.tmx").setMapY((world.getWorldMap("src/res/xml/mu1.tmx").getMapY()+16));
                    world.getWorldMap("src/res/xml/myMap.tmx").setMapY((world.getWorldMap("src/res/xml/myMap.tmx").getMapY()+16));
                }
                if (world.getWorldObjectById(1).getYPosition() > 500) {
                    world.getWorldObjectById(1).setYPosition((world.getWorldObjectById(1).getYPosition()-16));
                    world.getWorldMap("src/res/xml/mu1.tmx").setMapY((world.getWorldMap("src/res/xml/mu1.tmx").getMapY()-16));
                    world.getWorldMap("src/res/xml/myMap.tmx").setMapY((world.getWorldMap("src/res/xml/myMap.tmx").getMapY()-16));
                }
                vw.updateDisplay();
                System.out.println(world.getWorldObjectById(1).getYPosition());
                System.out.println("moved");
                adapter.setMotionEnabled(false);
            }

            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cortex_Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void resume() {
        running = true;
        System.out.println("Game has Resumed");
        vw.removePanel(startScreen.getPanel());

        world.createWorld();

        r.setWorld(world);
        vw.setDisplayImage(r.getCompositeRender());
        vw.getDisplayPanel().setFocusable(true);
        vw.getDisplayPanel().requestFocusInWindow();
        vw.getDisplayPanel().addKeyListener(controller);

        vw.updateDisplay();

    }

    private void exit() {
        running = false;
        System.out.println("Game has Stopped");
    }

    private void pause() {
        System.out.println("Game has Paused");
    }

    private void start() {
        System.out.println("Game has Started");

        vw.addPanel(startScreen.getPanel());

        startScreen.getPanel().setFocusable(true);
        startScreen.getPanel().requestFocusInWindow();
        startScreen.getPanel().addKeyListener(controller);
        for (JButton button : startScreen.getButtons()) {
            button.addActionListener(controller);
        }
        vw.updateDisplay();
    }

    private void init() {
        clientState.setState(clientState.START);
        adapter.setState(clientState);
        adapter.setController(controller);
        running = true;

    }
}
