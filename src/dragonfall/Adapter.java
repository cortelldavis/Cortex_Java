/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package dragonfall;

import dragonfall.Controller.Command;
import world.WorldObject;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class Adapter {
    /*
     * This class provides an interface between the classes that handle various tasks 
     */

    private Controller controller;
    private GameState state;
    private boolean TEMPFLAG = false;
    private boolean motion = false;

    public Adapter() {
        //contructor

        /*
        
         if controller is enabled
        
         monitor inputs
        
         if inputs are active
        
         map them to the state, then respond wiht the approriate actions
        
        
        
        
         */
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    void loop() {
        //System.out.println("looping");
        // state.onStart();
        //state.onExit();
        //state.onResume();

        if (!TEMPFLAG) {
            state.onStart();
            TEMPFLAG = !TEMPFLAG;
        }

        if (controller.isKeyPressed()) {

            if (controller.getCommand() == Command.UP) {
                System.out.println("Up");
                setMotionEnabled(true);
            }
            if (controller.getCommand() == Command.LEFT) {
                System.out.println("Left");
                setMotionEnabled(true);
            }
            if (controller.getCommand() == Command.DOWN) {
                System.out.println("Down");
                setMotionEnabled(true);
            }
            if (controller.getCommand() == Command.RIGHT) {
                System.out.println("Right");
                setMotionEnabled(true);

            }
            controller.setKeyPressed(false);
        }

        if (controller.isButtonPressed()) {
            System.out.println(controller.inputType);
            controller.setButtonPressed(false);

            if (controller.inputType.equals("Start Game")) {
                state.onResume();
            }
        }
        /*
         while (state.isStarting()) {
         }
         while (state.isPausing()) {
         }
         while (state.isResuming()) {

         }
         while (state.isExiting()) {
         }
         */
    }

    boolean isMotionEnabled() {
        return motion;
    }

    public void setMotionEnabled(boolean motion) {
        this.motion = motion;
    }

    void setObjectDirection(WorldObject worldObject) {
        if (controller.getCommand() == Command.UP) {
            worldObject.setDirection(Direction.NORTH);
        }
        if (controller.getCommand() == Command.LEFT) {
            worldObject.setDirection(Direction.WEST);
        }
        if (controller.getCommand() == Command.DOWN) {
            worldObject.setDirection(Direction.SOUTH);
        }
        if (controller.getCommand() == Command.RIGHT) {
            worldObject.setDirection(Direction.EAST);
        }

    }

}
