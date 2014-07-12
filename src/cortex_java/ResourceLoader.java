package cortex_java;

import data.XML_Parser;
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
    static XML_Parser parser = new XML_Parser();

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
        worldObject.setSize(0, 0, 32, 32);
        worldObject.setPosition(100, 100);
        worldObject.setTexture("../res/images/spritesheet_1.png", 0, 0, 96, 128, 0, 0, 32, 32);
        worldObject.setCollidable(true);
        
        
        return worldObject;
    }
}
