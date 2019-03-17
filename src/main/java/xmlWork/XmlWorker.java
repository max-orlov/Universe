package xmlWork;

import galaxyClasses.Galaxy;
import galaxyClasses.Planet;
import galaxyClasses.Universe;
import generator.RandomGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class XmlWorker {
    private File xml;
    private Universe universe;
    ArrayList<Galaxy> galaxies;

    public XmlWorker(Universe universe) {
        this.universe = universe;
    }

    public XmlWorker(String xml) throws IOException, SAXException, ParserConfigurationException {
        this.xml = new File(xml);
        this.galaxies = universeParse();
    }

    public void UniverseToXML() throws IOException {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        xml += "<universe>";
        for (int i = 0; i < this.universe.getGalaxies().size(); i++) {
            xml += "<galaxy>";
            Galaxy galaxy = this.universe.getGalaxies().get(i);
            for (int j = 0; j < galaxy.getPlanets().size(); j++) {
                Planet planet = galaxy.getPlanets().get(j);
                xml += "<planet>" + "<name>" + planet.getName() + "</name>" + "</planet>";
            }
            xml += "</galaxy>";
        }
        xml += "</universe>";
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.xml));
        writer.write(xml);
        writer.close();
    }

    public ArrayList<Galaxy> universeParse() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(this.xml);

        ArrayList<Galaxy> galaxies = new ArrayList<>();
        NodeList galaxiesNodeList = document.getElementsByTagName("galaxy");

        for (int i = 0; i < galaxiesNodeList.getLength(); i++) {
            Galaxy galaxy = new Galaxy("G" + RandomGenerator.numGenerator(1,1000));
            NodeList planetNodeList = galaxiesNodeList.item(i).getChildNodes();
            for (int j = 0; j < planetNodeList.getLength(); j++) {
                if(planetNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Planet planet = new Planet();
                    NodeList planetNameNodelist = planetNodeList.item(j).getChildNodes();
                    for (int k = 0; k < planetNameNodelist.getLength(); k++) {
                        Node planetNameNode = planetNameNodelist.item(k);
                        if (planetNameNode.getNodeType() == Node.ELEMENT_NODE) {
                            String planetName = planetNameNode.getNodeName();
                            if (planetName.equals("name"))
                                planet.setName(planetNameNode.getTextContent());
                        }
                    }
                /*Node item = planetNodeList.item(j);
                if(item.getNodeType() == Element.ELEMENT_NODE){
                    Element element = (Element) item;
                    planet.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    galaxy.addPlanet(planet);
                }*/
                    galaxy.addPlanet(planet);
                }
            }
            galaxies.add(galaxy);
        }
        this.galaxies = galaxies;
        return galaxies;
    }
}
