/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import world.World;
import world.WorldEvent;
import world.WorldListener;
import world.WorldObject;

/**
 *
 * @author cortell davis
 */
public class Renderer implements WorldListener {

    BufferedImage compositeLayer, compositeArray[];
    Graphics2D composite_GO;
    World world;

    public Renderer() {
        compositeLayer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        composite_GO = compositeLayer.createGraphics();

        compositeArray = new BufferedImage[10];
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

    public void render(WorldMap worldMap) {
        ArrayList<Point> coords = new ArrayList<Point>();
        HashMap gidTileCoordinates = new HashMap< Point, Integer>();

        int gidPallete = 1, gidX = 0, gidY = 0;

        BufferedImage[] mapPallete = new BufferedImage[worldMap.getSource().size()];
        BufferedImage temp = new BufferedImage(Integer.parseInt(worldMap.getWidth()) * Integer.parseInt(worldMap.getTileWidth()), Integer.parseInt(worldMap.getHeight()) * Integer.parseInt(worldMap.getTileHeight()), BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < worldMap.getSource().size(); i++) {
            mapPallete[i] = ResourceLoader.getImage((String) worldMap.getSource().get(i));

        }

        int gidCount = 0;

        for (int palleteCount = 0; palleteCount < worldMap.getSource().size(); palleteCount++) {

            int gidRow, gidColumn;

            for (gidRow = 0; gidRow < mapPallete[palleteCount].getHeight(); gidRow += 32) {

                for (gidColumn = 0; gidColumn < mapPallete[palleteCount].getWidth(); gidColumn += 32) {

                    coords.add(new Point(gidColumn, gidRow));
                    gidTileCoordinates.put((gidCount + 1), coords.get(gidCount));

                    // System.out.print("current Gid: "+(gidCount));
                    //System.out.println(", Gid Coordinates: "+coords.get(gidCount));
                    gidCount++;
                }

                gidColumn = 0;

            }

            // System.out.println(worldMap.getSource().get(palleteCount));
            //System.out.println(gidTileCoordinates.entrySet());
        }

        //gid
        for (int index = 0; index < worldMap.getSource().size(); index++) {
            //System.out.println(worldMap.getSource().get(index));
            //System.out.println(coords.get(index));
            // System.out.println("index: " + index + " = gid: " + worldMap.getMapping().get(index));

            // gidTileCoordinates.put(index, coords.get(index));map v
            String currentGid = worldMap.getMapping().get(index);

            //System.out.println("current coordinates for gid : "+coords.get(index));
            // gidTileCoordinates.put(currentGid, coords.get(index));
        }
        // System.out.println(coords.toString());
        //  System.out.println(gidTileCoordinates.entrySet());

        int count = 0;

        //map
        for (int row = 0; row < Integer.parseInt(worldMap.getHeight()); row++) {

            int column;

            for (column = 0; column < Integer.parseInt(worldMap.getWidth()); column++) {

                Integer gid = Integer.parseInt(worldMap.getMapping().get(count));
                Point gidPoint = (Point) gidTileCoordinates.get(gid);
                System.out.println("count: " + count + " gid: " + gid + " Coords: " + gidPoint);

                gidX = gidPoint.x;
                gidY = gidPoint.y;
                if (gid <= 12) {
                    gidPallete = 0;
                }
                
                if (gid >= 13&&gid<25) {
                    gidPallete = 1;
                }
                
                if (gid >= 25) {
                    gidPallete = 2;
                }
                
                
                
                temp.getGraphics().drawImage(mapPallete[gidPallete].getSubimage(gidX, gidY, 32, 32), column * 32, row * 32, null);

                count++;
            }
            column = 0;
        }
        System.out.println(gidTileCoordinates.entrySet());
        System.out.println(worldMap.getMapping().entrySet());

        compositeArray[0] = temp;

    }

    private void render(World world) {

        //render local map
        render(world.getWorldMap());
        //render world objects
        renderWorldObject(world.getWorldObjectById(2));

        //testing purposes
        composite_GO.setColor(Color.BLACK);
        composite_GO.fillRect(0, 0, 800, 600);
        composite_GO.drawImage(compositeArray[0], 0, 0, 800, 600, null);
        composite_GO.drawImage(compositeArray[1], 0, 0, null);
    }

    public void renderWorldObject(WorldObject worldObject) {

        compositeArray[1] = ResourceLoader.getImage(worldObject.getTexture().getTextureAddress()).getSubimage(worldObject.getTexture().getTextureSource_x1(), worldObject.getTexture().getTextureSource_y1(), 96, 128);

    }
}
