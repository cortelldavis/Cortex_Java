/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package world;

import java.awt.Point;
import java.util.*;
import world.WorldObject;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class WorldMap {

    //The Map Class will handle the positioning of world objects ,the layout of floor tiles, the collection of in world things, and other map related things. 
    //The Map Class will also handle nodes, grids, cells, and local map transitions to other adjacent maps.
    private HashMap<Integer, String> mapping;
    private String width, height, tileWidth, tileHeight, filename;
    private int mapX=0,mapY=0;
    private ArrayList<String> source;
    
    public int getMapX() {
        return mapX;
    }

    public void setMapX(int mapX) {
        this.mapX = mapX;
    }

    public int getMapY() {
        return mapY;
    }

    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(String tileWidth) {
        this.tileWidth = tileWidth;
    }

    public String getTileHeight() {
        return tileHeight;
    }

    public void setTileHeight(String tileHeight) {
        this.tileHeight = tileHeight;
    }

    public ArrayList getSource() {
        return source;
    }

    public void setSource(ArrayList source) {
        this.source = source;
    }

    /*
     * The map will have Integer instances as keys, and String instances as values. This means an integer 30 can be mapped to an address "greentile.png" this allows for
     * lightweight map data collection as opposed to storing the actual images in each node, instead nodes can just be mapped linearly from index(1) < mapNode.getNodeCount();
     */
    public HashMap<Integer, String> getMapping() {
        return mapping;
    }

    public void setMapping(HashMap mapping) {
        this.mapping = mapping;
    }

    public WorldMap() {
    }

    public void printMap() {
        System.out.println(mapping.entrySet());
        System.out.println(width);
        System.out.println(height);
        System.out.println(tileWidth);
        System.out.println(tileHeight);
        System.out.println(source.toString());
    }

    private class MapGrid {

        //this private class allows for positioning of world objects.
        Point nodeSize, gridSize;

        ArrayList<Point> nodeList;

        public void addObjectToGrid(WorldObject worldObject, int index) {
            worldObject.setPosition(nodeList.get(index));
        }

    }
}
