/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.awt.event.*;

/**
 *
 * @author cortell davis
 */
public class Controller implements KeyListener {

    private boolean keyPressed = false;

    Command command;

    public Controller() {

    }

    public boolean isKeyPressed() {
        return keyPressed;
    }

    public void setKeyPressed(boolean pressed) {
        keyPressed = pressed;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        setKeyPressed(true);

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
                command = Command.UP;
                break;
            case KeyEvent.VK_LEFT:
                command = Command.LEFT;
                break;
            case KeyEvent.VK_DOWN:
                command = Command.DOWN;
                break;
            case KeyEvent.VK_RIGHT:
                command = Command.RIGHT;
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    enum Command {

        LEFT, RIGHT, UP, DOWN, NONE
    }
}
