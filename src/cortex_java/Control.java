package cortex_java;

import java.awt.event.*;
import javax.swing.JComponent;

public class Control implements KeyListener {

    private boolean keyPressed = false;
    Direction direction;

    public Control() {

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
                direction = Direction.UP;
                break;
            case KeyEvent.VK_LEFT:
                direction = Direction.LEFT;
                break;
            case KeyEvent.VK_DOWN:
                direction = Direction.DOWN;
                break;
            case KeyEvent.VK_RIGHT:
                direction = Direction.RIGHT;
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    Direction getDirection() {
        return direction;
    }

}
