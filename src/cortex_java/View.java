/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.awt.*;

import java.awt.image.BufferedImage;

import javax.swing.*;

/**
 *
 * @author cortell davis
 */
public class View extends JFrame {

    private DisplayPanel dp;

    public View() {
        setTitle("Cortex Game Client");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        dp = new DisplayPanel();
        add(dp);
        setLayout(null);
        dp.setBounds(0, 0, 800, 600);
    }

    public void setDisplayImage(BufferedImage targetDisplay) {
        dp.setDisplay(targetDisplay);
        repaint();
        setVisible(true);
    }

    public void updateDisplay() {
        repaint();
        setVisible(true);
    }

    public JPanel getDisplayPanel() {
        return dp;
    }

    public void addPanel(JPanel panel) {
        dp.add(panel);
    }

    public void removePanel(JPanel panel) {
        dp.remove(panel);
    }

}
