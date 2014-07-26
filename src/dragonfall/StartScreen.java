/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package dragonfall;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
class StartScreen {

    private Panel panel;
    private BufferedImage img;
    private ArrayList<JButton> buttons;

    public ArrayList<JButton> getButtons() {
        return buttons;
    }
    
    public BufferedImage getImg() {
        return img;
    }

    public DisplayPanel getPanel() {
        return panel;
    }


    public StartScreen() {
        img = ResourceLoader.getImage("/res/images/startscreen.png");
        buttons = new ArrayList<JButton>();
        buttons.add(new JButton("New Game"));
        buttons.add(new JButton("Load Game"));
        buttons.add(new JButton("Options"));
        buttons.add(new JButton("Exit Game"));
        panel = new Panel();
        panel.setBounds(0,0,800,600);

    }





    private class Panel extends DisplayPanel {

        public Panel() {
            
             setLayout(new FlowLayout(FlowLayout.CENTER));
             for (JButton button : buttons) {
             add(button);
             }

   
        
             

        }

        @Override
        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, this);
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 42)); 
            g.drawString("Start Game",(getWidth()/2)-100,getHeight()/2);
        }
    }
}
