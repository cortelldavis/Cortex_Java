package cortex_java;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
/**
 *
 * @author cortell davis
 */
public class ResourceLoader {

	static ResourceLoader rl = new ResourceLoader();

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
        
        //get resource - xml - actor - world object
}
