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
 * @author cortell davis
 */
public class Renderer implements WorldListener {

    BufferedImage activeImage, staticImage;
    Graphics2D active_GO, static_GO;
    World world;

    BufferedImage worldLayer;

    public Renderer() {

        
        
    }

    @Override
    public void onWorldEvent(WorldEvent e) {

        System.out.println("Renderer has detected a change in the world");
        render();
    }

    @Override
    public void listenToWorld(World world) {

        world.addWorldListener(this);
    }

    void renderWorldObject(WorldObject worldObject) {

        //worldObject.getPosition();
        //worldObject.getSize();
        //worldObject.isCollidable();
        worldObject.getTexture();
        active_GO.setColor(Color.black);
        active_GO.fillRect(0, 0, activeImage.getWidth(), activeImage.getHeight());
        active_GO.drawImage(ResourceLoader.getImage(worldObject.getTexture().getTextureAddress()), worldObject.getXPosition(), worldObject.getYPosition(), (int) (worldObject.getXPosition() + worldObject.getWidth()), (int) (worldObject.getYPosition() + worldObject.getHeight()), worldObject.getTexture().textureSource_x1, worldObject.getTexture().textureSource_y1, worldObject.getTexture().textureSource_x2, worldObject.getTexture().textureSource_y2, null);
        static_GO.drawImage(activeImage, 0, 0, null);
    }

    public BufferedImage getCompositeRender() {
        return new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    }

    void setWorld(World target) {
        world = target;
        listenToWorld(world);
    }

    void render() {

        renderWorldObject(world.getWorldObject());
    }

}
