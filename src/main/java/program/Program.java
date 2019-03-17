package program;

import galaxyClasses.Galaxy;
import galaxyClasses.Universe;
import generator.RandomGenerator;
import org.xml.sax.SAXException;
import xmlWork.XmlWorker;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Universe universe = new Universe();
        XmlWorker xmlWorker = new XmlWorker("Universe.xml");
        ArrayList<Galaxy> galaxies = xmlWorker.universeParse();
        System.out.println(galaxies);
    }
}
