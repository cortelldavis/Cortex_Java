/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author agent
 */
public class Renderer implements WorldListener {

    BufferedImage activeImage, staticImage;
    Graphics2D active_GO, static_GO;

    public Renderer() {
        addWorldListener(this);
    }

    BufferedImage renderAndGetNewScene() {
        staticImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        static_GO = staticImage.createGraphics();

        activeImage = ResourceLoader.getImage("img.png");
        active_GO = (Graphics2D) activeImage.getGraphics();
        active_GO.setColor(Color.white);
        active_GO.fillRect(0, 0, activeImage.getWidth(), activeImage.getHeight());
        active_GO.drawImage(ResourceLoader.getImage("img.png"), 0, 0, 32, 32, 0, 0, 32, 32, null);
        static_GO.setColor(Color.black);
        static_GO.fillRect(0, 0, 800, 600);
        static_GO.drawImage(activeImage, 0, 0, null);

        return staticImage;
    }

    

    @Override
    public void OnWorldEvent(WorldEvent e) {

    System.out.println("Something has happened in the world");
    }

    static private void addWorldListener(WorldListener wl) {

        World.addWorldListener(wl);
    }

}
