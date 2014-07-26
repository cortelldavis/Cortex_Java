/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
class DisplayPanel extends JPanel {

    public Graphics2D displayPanelGraphicsObject, displayImageGraphicsObject;
    BufferedImage displayImage;

    public DisplayPanel() {
        displayImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        displayImageGraphicsObject = (Graphics2D) displayImage.createGraphics();
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        displayPanelGraphicsObject = (Graphics2D) g;
        super.paintComponent(displayPanelGraphicsObject);
        displayPanelGraphicsObject.setColor(Color.gray);
        displayPanelGraphicsObject.fillRect(0, 0, getWidth(), getHeight());
        displayPanelGraphicsObject.drawImage(displayImage, 0, 0, this);
    }

    public void setDisplay(BufferedImage targetDisplay) {
        displayImage = targetDisplay;
    }

}
