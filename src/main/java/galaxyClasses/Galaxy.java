package galaxyClasses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

@XmlRootElement(name = "galaxy")
@XmlType(propOrder = { "name", "planets" })
@XmlSeeAlso(Planet.class)
public class Galaxy {

    private String name;

   @XmlElement(name = "planet")
    private ArrayList<Planet> planets = new ArrayList<>();

    public Galaxy() {
    }

    public Galaxy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void addPlanets(Planet... planets) {
        this.planets.addAll(Arrays.asList(planets));
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public void removePlanet(String planetName) {
        for (int i = 0; i < this.planets.size(); i++) {
            if(planets.get(i).getName().equals(planetName))
                planets.remove(i);
        }
    }

    public void  removePlanet(Planet planet) {
        for (int i = 0; i < this.planets.size(); i++) {
            if(planets.get(i).equals(planet))
                planets.remove(i);
        }
    }

    public int searchPlanet(String planetName){
        for (int i = 0; i < this.planets.size(); i++) {
            if (this.planets.get(i).getName().equals(planetName))
                return i;
        }
        return -1;
    }

    public int searchPlanet(Planet planet){
        for (int i = 0; i < this.planets.size(); i++) {
            if (this.planets.get(i).equals(planet))
                return i;
        }
        return -1;
    }

    public String behavior() {
        String result = "Galaxy: " + this.name + "\n";
        for (int i = 0; i < this.planets.size(); i++) {
            result += "\t" + this.planets.get(i).behavior() + "\n";
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Galaxy galaxy1 = (Galaxy) o;
        return Objects.equals(planets, galaxy1.planets) &&
                Objects.equals(name, galaxy1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planets, name);
    }

    @Override
    public String toString() {
        return "Galaxy " + getName() + " = "
                 + planets;
    }
}
