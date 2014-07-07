package cortex_java;

import java.awt.*;

import java.awt.image.BufferedImage;

import javax.swing.*;

public class View extends JFrame {

    DisplayPanel dp;

    public View() {
        setBounds(400, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        dp = new DisplayPanel();
        add(dp);
    }

    void setDisplay(BufferedImage targetDisplay) {
        dp.setDisplay(targetDisplay);
        repaint();
        setVisible(true);
    }

}

class DisplayPanel extends JPanel {

    Graphics2D displayPanelGraphicsObject, displayImageGraphicsObject;
    BufferedImage displayImage;

    public DisplayPanel() {
        displayImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        displayImageGraphicsObject = (Graphics2D) displayImage.createGraphics();
    }

    public void paintComponent(Graphics g) {
        displayPanelGraphicsObject = (Graphics2D) g;
        super.paintComponent(displayPanelGraphicsObject);
        displayPanelGraphicsObject.drawImage(displayImage, 0, 0, displayImage.getWidth(), displayImage.getHeight(), 0, 0, getWidth(),
                getHeight(), this);
    }

    void setDisplay(BufferedImage targetDisplay) {
        displayImage = targetDisplay;
    }

}
