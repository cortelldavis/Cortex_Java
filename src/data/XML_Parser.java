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

    public static void main(String argv[]) {

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

                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("id : " + eElement.getAttribute("id"));
                    System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("level : " + eElement.getElementsByTagName("level").item(0).getTextContent());
                    System.out.println("health : " + eElement.getElementsByTagName("health").item(0).getTextContent());
                    System.out.println("agility : " + eElement.getElementsByTagName("agility").item(0).getTextContent());
                    System.out.println("strength : " + eElement.getElementsByTagName("strength").item(0).getTextContent());
                    System.out.println("willpower : " + eElement.getElementsByTagName("willpower").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
