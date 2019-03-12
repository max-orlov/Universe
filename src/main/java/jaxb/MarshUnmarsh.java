package jaxb;

import galaxyClasses.Galaxy;
import galaxyClasses.Planet;
import galaxyClasses.Universe;
import generator.RandomGenerator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class MarshUnmarsh {
    public static void main(String[] args) throws JAXBException, IOException {

/*        Planet planet = RandomGenerator.planetGenerator();
        FileOutputStream stream = new FileOutputStream("planet.xml");

        JAXBContext context = JAXBContext.newInstance(Planet.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(planet, stream);*/

/*        Galaxy galaxy = RandomGenerator.galaxyGenerator();
        FileOutputStream stream = new FileOutputStream("galaxy.xml");

        JAXBContext context = JAXBContext.newInstance(Galaxy.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(galaxy, stream);

        FileInputStream inputStream = new FileInputStream("galaxy.xml");
        JAXBContext context1 = JAXBContext.newInstance(Galaxy.class);
        Unmarshaller unmarshaller = context1.createUnmarshaller();
        Galaxy galaxy1 = (Galaxy) unmarshaller.unmarshal(inputStream);
        System.out.println(galaxy1.toString());*/

        Universe universe = new Universe();
        universe.addGalaxies();
        FileOutputStream stream = new FileOutputStream("Universe");

        JAXBContext context = JAXBContext.newInstance();
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(universe, stream);

    }
}
