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

    BufferedImage activeImage, compositeLayer;
    Graphics2D active_GO, composite_GO;
    World world;

    BufferedImage worldLayer[];

    public Renderer() {

        worldLayer = new BufferedImage[10];

        worldLayer[0] = new BufferedImage(96, 128, BufferedImage.TYPE_INT_ARGB);
        //holds a single pritesheet
        worldLayer[1] = new BufferedImage(32, 32, BufferedImage.TYPE_INT_ARGB);
        //holds a single frame
        worldLayer[2] = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        //holds a single local map

        compositeLayer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        //holds all layers into a composite

        composite_GO = compositeLayer.createGraphics();
        composite_GO.setColor(Color.black);
        composite_GO.fillRect(0, 0, compositeLayer.getWidth(), compositeLayer.getHeight());
        composite_GO.setColor(Color.white);
        composite_GO.drawString("Composite Layer", 390, 290);
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
        /*
         //worldObject.getPosition();
         //worldObject.getSize();
         //worldObject.isCollidable();
         worldObject.getTexture();
         active_GO.setColor(Color.black);
         active_GO.fillRect(0, 0, activeImage.getWidth(), activeImage.getHeight());
         active_GO.drawImage(ResourceLoader.getImage(worldObject.getTexture().getTextureAddress()), worldObject.getXPosition(), worldObject.getYPosition(), (int) (worldObject.getXPosition() + worldObject.getWidth()), (int) (worldObject.getYPosition() + worldObject.getHeight()), worldObject.getTexture().textureSource_x1, worldObject.getTexture().textureSource_y1, worldObject.getTexture().textureSource_x2, worldObject.getTexture().textureSource_y2, null);
         static_GO.drawImage(activeImage, 0, 0, null);
         */
    }

    public BufferedImage getCompositeRender() {
        return compositeLayer;
    }

    void setWorld(World target) {
        world = target;
        listenToWorld(world);
    }

    void render() {

        renderWorldObject(world.getWorldObject());
    }

}
