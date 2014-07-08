package cortex_java;

import java.awt.event.*;
import javax.swing.JComponent;

public class Control implements KeyListener {

    private boolean keyPressed = false;

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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
