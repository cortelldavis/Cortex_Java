/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import data.Actor_XML_Parser;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import world.WorldObject;

/**
 *
 * @author cortell davis
 */
public class ResourceLoader {

    static ResourceLoader rl = new ResourceLoader();
    static Actor_XML_Parser parser = new Actor_XML_Parser();

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
        parser.parseObjectById(id);

        //actor properties
        worldObject.setActor_Name(parser.getName());
        worldObject.setLevel(Integer.parseInt(parser.getLevel()));
        worldObject.setHealth(Integer.parseInt(parser.getHealth()));
        worldObject.setAgility(Integer.parseInt(parser.getAgility()));
        worldObject.setStrength(Integer.parseInt(parser.getStrength()));
        worldObject.setWillpower(Integer.parseInt(parser.getWillpower()));

        //world properties
        worldObject.setSize(Integer.parseInt(parser.getSize_x1()), Integer.parseInt(parser.getSize_y1()), Integer.parseInt(parser.getSize_x2()), Integer.parseInt(parser.getSize_y2()));
        worldObject.setId(Integer.parseInt(parser.getId()));
        worldObject.setTexture(parser.getTexture_address(), Integer.parseInt(parser.getTexture_source_x1()), Integer.parseInt(parser.getTexture_source_y1()), Integer.parseInt(parser.getTexture_source_x2()), Integer.parseInt(parser.getTexture_source_y2()), (Integer.parseInt(parser.getTexture_frame_y1())), (Integer.parseInt(parser.getTexture_frame_x1())), (Integer.parseInt(parser.getTexture_frame_x2())), (Integer.parseInt(parser.getTexture_frame_y2())));
        worldObject.setCollidable(Boolean.parseBoolean(parser.getCollidable()));

        //objects location needs to be derived from a local map class, default value (0,0)
        worldObject.setPosition(0, 0);
        return worldObject;
    }
}
