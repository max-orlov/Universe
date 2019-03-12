package galaxyClasses;

import generator.RandomGenerator;
import javafx.util.Pair;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

@XmlRootElement(name = "Universe")
@XmlType(propOrder = { "name", "galaxy" })
public class Universe{

    private String name;

    @XmlElement(name = "galaxy")
    private ArrayList<Galaxy> galaxies = new ArrayList<>();

    public Universe() {
    }

    public String getName() {
        return this.name;
    }

    public void addGalaxy(Galaxy galaxy) {
        galaxies.add(galaxy);
    }

    public void addGalaxies(Galaxy... galaxies){
        this.galaxies.addAll(Arrays.asList(galaxies));
    }

    public int searchGalaxy(String galaxyName) {
        for (int i = 0; i < galaxies.size(); i++) {
            if(galaxies.get(i).getName().equals(galaxyName))
                return i;
        }
        return -1;
    }

    public int searchGalaxy(Galaxy galaxy) {
        for (int i = 0; i < galaxies.size(); i++) {
            if(galaxies.get(i).equals(galaxy))
                return i;
        }
        return -1;
    }

    public Pair<Integer, Integer> searchPlanet(String planetName) {
        for (int i = 0; i < galaxies.size(); i++) {
            Galaxy galaxy = galaxies.get(i);
            int i1 = galaxy.searchPlanet(planetName);
            if(i1 != -1)
                return new Pair<>(i, i1);
        }
        return null;
    }

    public int searchPlanet(Planet planet) {
        Galaxy galaxy = new Galaxy();
        return galaxy.searchPlanet(planet);
    }



    public void behavior() {
        System.out.println("Universe:" + "\n");
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < RandomGenerator.numGenerator(1, 5); i++) {
                    Galaxy galaxy = RandomGenerator.galaxyGenerator();
                    galaxies.add(galaxy);
                    System.out.println(galaxy);
                }
            }
        }, 0, 2000);
    }

    @Override
    public String toString() {
        return "Universe: " + "\n{" + galaxies + '}';
    }
}
