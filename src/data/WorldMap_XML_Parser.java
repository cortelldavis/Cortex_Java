/*
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Cortell Davis <cortelldavis@gmail.com>
 */
public class WorldMap_XML_Parser {

    private HashMap<Integer, String> mapping;
    private String width, height, tileWidth, tileHeight;
    ArrayList<String> source;

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

    public HashMap<Integer, String> getMapping() {
        return mapping;
    }

    public void parse(String filename) {
        mapping = new HashMap< Integer, String>();
        source = new ArrayList<String>();
        try {
            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("tile");
            NodeList nList2 = doc.getElementsByTagName("tileset");
            NodeList nList3 = doc.getElementsByTagName("map");

            for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node n = nList3.item(temp);
                Element e = (Element) n;

                width = e.getAttribute("width");
                height = e.getAttribute("height");
                tileWidth = e.getAttribute("tilewidth");
                tileHeight = e.getAttribute("tileheight");

            }
            for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node n = nList2.item(temp);
                Element e = (Element) n;
                source.add("../res/images/" + e.getAttribute("name") + ".png");
            }

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    mapping.put(temp, eElement.getAttribute("gid"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
