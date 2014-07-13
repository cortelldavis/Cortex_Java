/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.awt.Rectangle;

/**
 *
 * @author cortell davis
 */
public class Texture {

    String textureAddress;
    int textureSource_x1, textureSource_y1, textureSource_x2, textureSource_y2;

    int textureFrame_x1, textureFrame_y1, textureFrame_x2, textureFrame_y2;

    public void setTextureAddress(String filename) {
        textureAddress = filename;
    }

    public void setTextureSource(int x1, int y1, int x2, int y2) {
        textureSource_y1 = y1;
        textureSource_x1 = x1;
        textureSource_y2 = y2;
        textureSource_x2 = x2;
    }

    public void setTextureFrame(int x1, int y1, int x2, int y2) {
        textureFrame_x1 = x1;
        textureFrame_y1 = y1;
        textureFrame_x2 = x2;
        textureFrame_y2 = y2;
    }

    public Rectangle getTextureFrame() {
        return new Rectangle(textureFrame_x1, textureFrame_y1, textureFrame_x2, textureFrame_y2);
    }

    String getTextureAddress() {
        return textureAddress;
    }

}
