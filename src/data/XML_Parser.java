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
public class XML_Parser {

    public void parse() {

        try {

            File fXmlFile = new File("src/data/world_objects.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("npc");

            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\t" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    System.out.println("\n------------------------------\n\tStats\n------------------------------");
                    System.out.println("id : " + eElement.getAttribute("id"));
                    System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("level : " + eElement.getElementsByTagName("level").item(0).getTextContent());
                    System.out.println("health : " + eElement.getElementsByTagName("health").item(0).getTextContent());
                    System.out.println("agility : " + eElement.getElementsByTagName("agility").item(0).getTextContent());
                    System.out.println("strength : " + eElement.getElementsByTagName("strength").item(0).getTextContent());
                    System.out.println("willpower : " + eElement.getElementsByTagName("willpower").item(0).getTextContent());
                    System.out.println("\n------------------------------\n\tProperties\n------------------------------");
                    System.out.println("properties\n");
                    System.out.println("texture address : " + eElement.getElementsByTagName("texture_address").item(0).getTextContent());
                    System.out.println("texture_frame_y1 : " + eElement.getElementsByTagName("texture_frame_y1").item(0).getTextContent());
                    System.out.println("texture_frame_x1 : " + eElement.getElementsByTagName("texture_frame_x1").item(0).getTextContent());
                    System.out.println("texture_frame_y2 : " + eElement.getElementsByTagName("texture_frame_y2").item(0).getTextContent());
                    System.out.println("texture_frame_y2 : " + eElement.getElementsByTagName("texture_frame_y2").item(0).getTextContent());
                    System.out.println("texture_source_y1 : " + eElement.getElementsByTagName("texture_source_y1").item(0).getTextContent());
                    System.out.println("texture_source_x1 : " + eElement.getElementsByTagName("texture_source_x1").item(0).getTextContent());
                    System.out.println("texture_source_y2 : " + eElement.getElementsByTagName("texture_source_y2").item(0).getTextContent());
                    System.out.println("texture_source_x2 : " + eElement.getElementsByTagName("texture_source_x2").item(0).getTextContent());
                    System.out.println("collidable : " + eElement.getElementsByTagName("collidable").item(0).getTextContent());
                    System.out.println("size_x1 : " + eElement.getElementsByTagName("size_x1").item(0).getTextContent());
                    System.out.println("size_y1 : " + eElement.getElementsByTagName("size_y1").item(0).getTextContent());
                    System.out.println("size_x2 : " + eElement.getElementsByTagName("size_x2").item(0).getTextContent());
                    System.out.println("size_y2 : " + eElement.getElementsByTagName("size_y2").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
