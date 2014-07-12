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
        URL url = rl.getClass().getResource("" + filename);
        try {
            return ImageIO.read(url);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static WorldObject getWorldObjectById(String id) {
        WorldObject worldObject = new WorldObject();
        parser.parse();
        //assignment value sshould be retrieved from XML files
        worldObject.setSize(Integer.parseInt(parser.getSize_x1()), Integer.parseInt(parser.getSize_y1()), Integer.parseInt(parser.getSize_x2()), Integer.parseInt(parser.getSize_y2()));

        //objects location needs to be derived from a local map class
        worldObject.setPosition(100, 100);

        worldObject.setTexture(parser.getTexture_address(), Integer.parseInt(parser.getTexture_source_x1()), Integer.parseInt(parser.getTexture_source_y1()), Integer.parseInt(parser.getTexture_source_x2()), Integer.parseInt(parser.getTexture_source_y2()), 0, 0, 32, 32);
        worldObject.setCollidable(Boolean.parseBoolean(parser.getCollidable()));
        parser = null;
        return worldObject;
    }
}
