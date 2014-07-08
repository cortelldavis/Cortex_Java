/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cortex_java;

/**
 *
 * @author agent
 */
public class Texture {

    String textureAddress;
    int y1, y2, x1, x2;

    public void setTextureAddress(String filename) {
        textureAddress = filename;
    }

    public void setTextureSource(int y1, int x1, int y2, int x2) {
        this.y1 = y1;
        this.x1 = x1;
        this.y2 = y2;
        this.x2 = x2;
    }

    String getFileName() {
        return textureAddress;
    }
}
