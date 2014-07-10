/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author cortell davis
 */
public class XML_Parser {

    public static void main(String[] args) {
        // TODO code application logic here

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {

            InputStream xmlInput = new FileInputStream("src/data/world_objects.xml");
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new XML_Handler();
            saxParser.parse(xmlInput, handler);

        } catch (ParserConfigurationException | SAXException | IOException err) {
        }
    }
}

class XML_Handler extends DefaultHandler {

    public void startDocument() throws SAXException {
        System.out.println("start document: ");
    }

    public void endDocument() throws SAXException {
        System.out.println("end document: ");
    }

    public void startElement(String uri, String localName,
            String qName, Attributes attributes)
            throws SAXException {

        System.out.println("val: " + qName);

    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("end element: " + qName);
    }

    public void characters(char ch[], int start, int length)
            throws SAXException {
        System.out.println("start characters: "
                + new String(ch, start, length));
    }

    public void ignorableWhitespace(char ch[], int start, int length)
            throws SAXException {
    }

}
