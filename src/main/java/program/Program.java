package program;

import dom.DOMParser;
import galaxyClasses.Galaxy;
import galaxyClasses.Planet;
import galaxyClasses.Universe;
import generator.RandomGenerator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        Universe universe = new Universe();
        universe.addGalaxy(RandomGenerator.galaxyGenerator());
        universe.addGalaxy(RandomGenerator.galaxyGenerator());
        universe.addGalaxy(RandomGenerator.galaxyGenerator());
        System.out.println(universe.toString());
    }

}
