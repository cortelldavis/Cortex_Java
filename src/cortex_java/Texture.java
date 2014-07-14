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

    private String textureAddress;
    private int textureSource_x1, textureSource_y1, textureSource_x2, textureSource_y2;

    private int textureFrame_x1, textureFrame_y1, textureFrame_x2, textureFrame_y2;

    public int getTextureSource_x1() {
        return textureSource_x1;
    }

    public void setTextureSource_x1(int textureSource_x1) {
        this.textureSource_x1 = textureSource_x1;
    }

    public int getTextureSource_y1() {
        return textureSource_y1;
    }

    public void setTextureSource_y1(int textureSource_y1) {
        this.textureSource_y1 = textureSource_y1;
    }

    public int getTextureSource_x2() {
        return textureSource_x2;
    }

    public void setTextureSource_x2(int textureSource_x2) {
        this.textureSource_x2 = textureSource_x2;
    }

    public int getTextureSource_y2() {
        return textureSource_y2;
    }

    public void setTextureSource_y2(int textureSource_y2) {
        this.textureSource_y2 = textureSource_y2;
    }

    public int getTextureFrame_x1() {
        return textureFrame_x1;
    }

    public void setTextureFrame_x1(int textureFrame_x1) {
        this.textureFrame_x1 = textureFrame_x1;
    }

    public int getTextureFrame_y1() {
        return textureFrame_y1;
    }

    public void setTextureFrame_y1(int textureFrame_y1) {
        this.textureFrame_y1 = textureFrame_y1;
    }

    public int getTextureFrame_x2() {
        return textureFrame_x2;
    }

    public void setTextureFrame_x2(int textureFrame_x2) {
        this.textureFrame_x2 = textureFrame_x2;
    }

    public int getTextureFrame_y2() {
        return textureFrame_y2;
    }

    public void setTextureFrame_y2(int textureFrame_y2) {
        this.textureFrame_y2 = textureFrame_y2;
    }

    public void setTextureAddress(String filename) {
        textureAddress = filename;
    }

    String getTextureAddress() {
        return textureAddress;
    }

}
