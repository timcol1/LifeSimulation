package avlyakulov.timur.simulation.objects.resource;

import avlyakulov.timur.simulation.entity.Entity;

public class Apple extends Entity {

    private static int numberApples = 4;

    public static int getNumberApples() {
        return numberApples;
    }

    @Override
    public String toString() {
        return "\uD83C\uDF4E";
    }

}