/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

import world.World;
import world.WorldListener;
import world.WorldEvent;
import world.WorldObject;
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

    BufferedImage renderAndGetNewScene() {
        staticImage = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        static_GO = staticImage.createGraphics();

        activeImage = ResourceLoader.getImage("../res/images/spritesheet_1.png");
        active_GO = (Graphics2D) activeImage.getGraphics();
        active_GO.setColor(Color.white);
        active_GO.fillRect(0, 0, activeImage.getWidth(), activeImage.getHeight());
        static_GO.setColor(Color.black);
        static_GO.fillRect(0, 0, 800, 600);
        static_GO.drawImage(activeImage, 0, 0, null);

        return staticImage;
    }

    @Override
    public void onWorldEvent(WorldEvent e) {

        System.out.println("Renderer has detected a change in the world");
    }

    @Override
    public void listenToWorld(World world) {

        world.addWorldListener(this);
    }

    void renderWorldObject(WorldObject worldObject) {

        worldObject.getPosition();
        worldObject.getSize();
        //worldObject.isCollidable();
        worldObject.getTexture();
        active_GO.setColor(Color.black);
        active_GO.fillRect(0, 0, activeImage.getWidth(), activeImage.getHeight());
        active_GO.drawImage(ResourceLoader.getImage(worldObject.getTexture().getFileName()), worldObject.getXPosition(), worldObject.getYPosition(), (int) (worldObject.getXPosition() + worldObject.getWidth()), (int) (worldObject.getYPosition() + worldObject.getHeight()), worldObject.getTexture().x1, worldObject.getTexture().y1, worldObject.getTexture().x2, worldObject.getTexture().y2, null);
        static_GO.drawImage(activeImage, 0, 0, null);
    }

}
