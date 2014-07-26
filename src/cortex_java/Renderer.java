
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
        composite_GO.drawString("Composite Layer", 350, 290);

    }

    @Override
    public void onWorldEvent(WorldEvent e) {

        System.out.println("Renderer has detected a change in the world");
        render(world);
    }

    @Override
    public void listenToWorld(World world) {

        world.addWorldListener(this);
    }

    public BufferedImage getCompositeRender() {
        return compositeLayer;
    }

    void setWorld(World world) {
        this.world = world;
        listenToWorld(world);

        worldLayer[0] = ResourceLoader.getImage(world.getWorldObject().getTexture().getTextureAddress());
        worldLayer[0] = worldLayer[0].getSubimage(0, 0, 96, 128);

        render(world);
    }

    private void render(World world) {
        worldLayer[1] = worldLayer[0].getSubimage(world.getWorldObject().getTexture().getTextureFrame().x, world.getWorldObject().getTexture().getTextureFrame().y, world.getWorldObject().getTexture().getTextureFrame().width, world.getWorldObject().getTexture().getTextureFrame().height);
        // worldLayer[1] = worldLayer[0].getSubimage(32,32,32,32);

        composite_GO.setColor(Color.black);
        composite_GO.fillRect(0, 0, 800, 600);
        composite_GO.drawImage(worldLayer[1], world.getWorldObject().getXPosition(), world.getWorldObject().getYPosition(), null);
    }

}
