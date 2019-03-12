package galaxyClasses;

import generator.RandomGenerator;

import javax.xml.bind.annotation.*;
import java.util.Objects;


@XmlRootElement(name = "planet")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Planet {
    //@XmlElement
    private String name;

    public Planet() {
    }

    public Planet(String name) {
        this.name = name;
    }

    public String behavior() {
        return this.name + " is rotate";
    }

    public void setName(String name) {
        this.name = "P" + RandomGenerator.numGenerator(1,1000);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Planet " + name;
    }
}
