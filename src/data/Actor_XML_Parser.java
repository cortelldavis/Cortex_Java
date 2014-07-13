/* 
 *  You must contact the author of this material, and then ask for permission, before accepting the terms of this license.
 *  You are not free to copy and redistribute the material in any medium or format.
 *  You may view the material only to contribute to the material. 
 *  You may  not use the material in any commercial way.
 */
package data;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author cortell davis
 */
public class Actor_XML_Parser {

    private String texture_frame_y2;
    private String id;
    private String name;
    private String level;
    private String health;
    private String agility;
    private String strength;
    private String willpower;
    private String texture_address;
    private String texture_frame_x1;
    private String texture_frame_y1;

    public String getTexture_frame_y2() {
        return texture_frame_y2;
    }

    public void setTexture_frame_y2(String texture_frame_y2) {
        this.texture_frame_y2 = texture_frame_y2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAgility() {
        return agility;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getWillpower() {
        return willpower;
    }

    public void setWillpower(String willpower) {
        this.willpower = willpower;
    }

    public String getTexture_address() {
        return texture_address;
    }

    public void setTexture_address(String texture_address) {
        this.texture_address = texture_address;
    }

    public String getTexture_frame_x1() {
        return texture_frame_x1;
    }

    public void setTexture_frame_x1(String texture_frame_x1) {
        this.texture_frame_x1 = texture_frame_x1;
    }

    public String getTexture_frame_y1() {
        return texture_frame_y1;
    }

    public void setTexture_frame_y1(String texture_frame_y1) {
        this.texture_frame_y1 = texture_frame_y1;
    }

    public String getTexture_frame_x2() {
        return texture_frame_x2;
    }

    public void setTexture_frame_x2(String texture_frame_x2) {
        this.texture_frame_x2 = texture_frame_x2;
    }

    public String getTexture_source_x1() {
        return texture_source_x1;
    }

    public void setTexture_source_x1(String texture_source_x1) {
        this.texture_source_x1 = texture_source_x1;
    }

    public String getTexture_source_y1() {
        return texture_source_y1;
    }

    public void setTexture_source_y1(String texture_source_y1) {
        this.texture_source_y1 = texture_source_y1;
    }

    public String getTexture_source_x2() {
        return texture_source_x2;
    }

    public void setTexture_source_x2(String texture_source_x2) {
        this.texture_source_x2 = texture_source_x2;
    }

    public String getTexture_source_y2() {
        return texture_source_y2;
    }

    public void setTexture_source_y2(String texture_source_y2) {
        this.texture_source_y2 = texture_source_y2;
    }

    public String getCollidable() {
        return collidable;
    }

    public void setCollidable(String collidable) {
        this.collidable = collidable;
    }

    public String getSize_x1() {
        return size_x1;
    }

    public void setSize_x1(String size_x1) {
        this.size_x1 = size_x1;
    }

    public String getSize_y1() {
        return size_y1;
    }

    public void setSize_y1(String size_y1) {
        this.size_y1 = size_y1;
    }

    public String getSize_x2() {
        return size_x2;
    }

    public void setSize_x2(String size_x2) {
        this.size_x2 = size_x2;
    }

    public String getSize_y2() {
        return size_y2;
    }

    public void setSize_y2(String size_y2) {
        this.size_y2 = size_y2;
    }
    private String texture_frame_x2;
    private String texture_source_x1;
    private String texture_source_y1;
    private String texture_source_x2;
    private String texture_source_y2;
    private String collidable;
    private String size_x1;
    private String size_y1;
    private String size_x2;
    private String size_y2;

    public void parse() {

        try {

            File fXmlFile = new File("src/data/world_objects.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("npc");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    id = eElement.getAttribute("id");
                    name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    level = eElement.getElementsByTagName("level").item(0).getTextContent();
                    health = eElement.getElementsByTagName("health").item(0).getTextContent();
                    agility = eElement.getElementsByTagName("agility").item(0).getTextContent();
                    strength = eElement.getElementsByTagName("strength").item(0).getTextContent();
                    willpower = eElement.getElementsByTagName("willpower").item(0).getTextContent();
                    texture_address = eElement.getElementsByTagName("texture_address").item(0).getTextContent();
                    texture_frame_x1 = eElement.getElementsByTagName("texture_frame_x1").item(0).getTextContent();
                    texture_frame_y1 = eElement.getElementsByTagName("texture_frame_y1").item(0).getTextContent();
                    texture_frame_x2 = eElement.getElementsByTagName("texture_frame_x2").item(0).getTextContent();
                    texture_frame_y2 = eElement.getElementsByTagName("texture_frame_y2").item(0).getTextContent();
                    texture_source_x1 = eElement.getElementsByTagName("texture_source_x1").item(0).getTextContent();
                    texture_source_y1 = eElement.getElementsByTagName("texture_source_y1").item(0).getTextContent();
                    texture_source_x2 = eElement.getElementsByTagName("texture_source_x2").item(0).getTextContent();
                    texture_source_y2 = eElement.getElementsByTagName("texture_source_y2").item(0).getTextContent();
                    collidable = eElement.getElementsByTagName("collidable").item(0).getTextContent();
                    size_x1 = eElement.getElementsByTagName("size_x1").item(0).getTextContent();
                    size_y1 = eElement.getElementsByTagName("size_y1").item(0).getTextContent();
                    size_x2 = eElement.getElementsByTagName("size_x2").item(0).getTextContent();
                    size_y2 = eElement.getElementsByTagName("size_y2").item(0).getTextContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
