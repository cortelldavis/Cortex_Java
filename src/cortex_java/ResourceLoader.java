/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import data.Actor_XML_Parser;
import data.WorldMap_XML_Parser;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import world.WorldObject;

/**
 *
 * @author cortell davis
 */
public class ResourceLoader {

    private static ResourceLoader rl = new ResourceLoader();
    private static Actor_XML_Parser Actor_Parser = new Actor_XML_Parser();
    private static WorldMap_XML_Parser Map_Parser = new WorldMap_XML_Parser();

    public static BufferedImage getImage(String filename) {
        URL url = rl.getClass().getResource(filename);
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static WorldObject getWorldObjectById(int id) {
        Actor worldObject = new Actor();
        Actor_Parser.parseObjectById(id);

        //actor properties
        worldObject.setActor_Name(Actor_Parser.getName());
        worldObject.setLevel(Integer.parseInt(Actor_Parser.getLevel()));
        worldObject.setHealth(Integer.parseInt(Actor_Parser.getHealth()));
        worldObject.setAgility(Integer.parseInt(Actor_Parser.getAgility()));
        worldObject.setStrength(Integer.parseInt(Actor_Parser.getStrength()));
        worldObject.setWillpower(Integer.parseInt(Actor_Parser.getWillpower()));

        //world properties
        worldObject.setSize(Integer.parseInt(Actor_Parser.getSize_x1()), Integer.parseInt(Actor_Parser.getSize_y1()), Integer.parseInt(Actor_Parser.getSize_x2()), Integer.parseInt(Actor_Parser.getSize_y2()));
        worldObject.setId(Integer.parseInt(Actor_Parser.getId()));
        worldObject.setTexture(Actor_Parser.getTexture_address(), Integer.parseInt(Actor_Parser.getTexture_source_x1()), Integer.parseInt(Actor_Parser.getTexture_source_y1()), Integer.parseInt(Actor_Parser.getTexture_source_x2()), Integer.parseInt(Actor_Parser.getTexture_source_y2()), (Integer.parseInt(Actor_Parser.getTexture_frame_y1())), (Integer.parseInt(Actor_Parser.getTexture_frame_x1())), (Integer.parseInt(Actor_Parser.getTexture_frame_x2())), (Integer.parseInt(Actor_Parser.getTexture_frame_y2())));
        worldObject.setCollidable(Boolean.parseBoolean(Actor_Parser.getCollidable()));

        //objects location needs to be derived from a local map class, default value (0,0)
        worldObject.setPosition(0, 0);
        return worldObject;
    }

    public static WorldMap getWorldMap() {

        WorldMap worldMap = new WorldMap();
        Map_Parser.parse();

        worldMap.setMapping(Map_Parser.getMapping());
        worldMap.setHeight(Map_Parser.getHeight());
        worldMap.setSource(Map_Parser.getSource());
        worldMap.setTileHeight(Map_Parser.getTileHeight());
        worldMap.setTileWidth(Map_Parser.getTileWidth());
        worldMap.setWidth(Map_Parser.getWidth());
        return worldMap;
    }

}
