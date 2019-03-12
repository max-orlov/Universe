package program;

import dom.DOMParser;
import galaxyClasses.Galaxy;
import galaxyClasses.Planet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DOMParser domParser = new DOMParser("galaxy.xml");
        ArrayList<Planet> planets = domParser.galaxyParse();
        System.out.println(planets.toString());
    }

}
