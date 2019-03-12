package dom;

import galaxyClasses.Planet;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMParser {

    private File XML;
    private ArrayList<Planet> planets;

    public DOMParser(String XML) {
        this.XML = new File(XML);
    }

    public DOMParser(File XML) throws IOException, SAXException, ParserConfigurationException {
        this.XML = XML;
        this.planets = galaxyParse();
    }

    public Planet planetParser() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(XML);

        Node planet = document.getElementsByTagName("name").item(0);
        return new Planet(planet.getTextContent());
    }

    public ArrayList<Planet> galaxyParse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(XML);

        ArrayList<Planet> planets = new ArrayList<>();

        NodeList galaxyNodeList = document.getElementsByTagName("planet");
        for (int i = 0; i < galaxyNodeList.getLength(); i++) {
            Planet planet = new Planet();
            NodeList childePlanet = galaxyNodeList.item(i).getChildNodes();
            for (int j = 0; j < childePlanet.getLength(); j++) {
                Node planetName = childePlanet.item(j);
                if (planetName.getNodeType() == Node.ELEMENT_NODE) {
                    String name = planetName.getTextContent();
                    planet.setName(name);
                }
            }
            planets.add(planet);
        }
        this.planets = planets;
        return planets;
    }


        public ArrayList<Planet> getPlanets () {
            return planets;
        }
}