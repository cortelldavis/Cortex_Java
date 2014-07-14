/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
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

    BufferedImage compositeLayer;
    Graphics2D composite_GO;
    World world;



    public Renderer() {

    }

    @Override
    public void onWorldEvent(WorldEvent e) {

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

        render(world);
    }

    private void render(World world) {

        //render local map
        //render world objects
        
    }



}
