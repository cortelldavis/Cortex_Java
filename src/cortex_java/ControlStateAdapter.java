/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import cortex_java.Controller.Command;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class ControlStateAdapter {
    /*
     * This class provides an interface betweenst the controller and state objects of the Controller and GameState classes respectively. 
     */

    private Controller controller;
    private GameState state;

    public ControlStateAdapter() {
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

        state.onStart();
        state.onExit();

        while (state.isStarting()) {
        }
        while (state.isPausing()) {
        }
        while (state.isResuming()) {
        }
        while (state.isExiting()) {
        }

        /*if (controller.isKeyPressed()) {

         if (controller.getCommand() == Command.UP) {
         System.out.println("Up");
         }
         if (controller.getCommand() == Command.LEFT) {
         System.out.println("Left");
         }
         if (controller.getCommand() == Command.DOWN) {
         System.out.println("Down");
         }
         if (controller.getCommand() == Command.RIGHT) {
         System.out.println("Right");
      
         }
         controller.setKeyPressed(false);
         }*/
    }

}
