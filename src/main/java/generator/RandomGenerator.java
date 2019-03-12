package generator;

import galaxyClasses.Galaxy;
import galaxyClasses.Planet;

public class RandomGenerator {

    public RandomGenerator() {
    }

    public static int numGenerator(int a, int b) {
        return a + (int)(Math.random() * (b - a));
    }

    public static Planet planetGenerator() {
        Planet planet = new Planet("P" + RandomGenerator.numGenerator(1, 1000));
        return planet;
    }

    public static Galaxy galaxyGenerator() {
        Galaxy galaxy = new Galaxy("G" + RandomGenerator.numGenerator(1, 1000));
        for (int i = 0; i < numGenerator(1, 5); i++) {
            galaxy.addPlanet(planetGenerator());
        }
        return galaxy;
    }
}
