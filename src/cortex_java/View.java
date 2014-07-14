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

    DisplayPanel dp;

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

    void setDisplayImage(BufferedImage targetDisplay) {
        dp.setDisplay(targetDisplay);
        repaint();
        setVisible(true);
    }

    void updateDisplay() {
        repaint();
        setVisible(true);
    }

    DisplayPanel getDisplayPanel() {
        return dp;
    }

}

class DisplayPanel extends JPanel {

    public Graphics2D displayPanelGraphicsObject, displayImageGraphicsObject;
    BufferedImage displayImage;

    public DisplayPanel() {
        displayImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        displayImageGraphicsObject = (Graphics2D) displayImage.createGraphics();
    }

    public void paintComponent(Graphics g) {
        displayPanelGraphicsObject = (Graphics2D) g;
        super.paintComponent(displayPanelGraphicsObject);
        displayPanelGraphicsObject.setColor(Color.gray);
        displayPanelGraphicsObject.fillRect(0, 0, getWidth(), getHeight());
        displayPanelGraphicsObject.drawImage(displayImage, 0, 0, this);
    }

    void setDisplay(BufferedImage targetDisplay) {
        displayImage = targetDisplay;
    }

}
