/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package cortex_java;

import java.util.*;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class WorldMap {

    //The Map Class will handle the positioning of world objects ,the layout of floor tiles, the collection of in world things, and other map related things. 
    //The Map Class will also handle nodes, grids, cells, and local map transitions to other adjacent maps.
    HashMap<Integer, String> mapNode = new HashMap<Integer, String>();
    /*  
     * The map will have Integer instances as keys, and String instances as values. This means an integer 30 can be mapped to an address "greentile.png" this allows for 
     * lightweight map data collection as opposed to storing the actual images in each node, instead nodes can just be mapped linearly from index(1) < mapNode.getNodeCount();
     */

    public WorldMap() {
        for (Integer key : mapNode.keySet()) {
        }
    }
    /*
     *The above for loop will iterate through the mapNode and assign each node inside of a given map a pair of keys and values, that in conjunction
     *represent an index and a string address. The index points to a rectangle that is used to represent cells or grids in the game(for floor textures it would be 128 x 128 px rects) , and
     *the string address is a filename that points to a image file residing in the res/images project directory.
    */
    
    
    
}
