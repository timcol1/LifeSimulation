package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Fox extends Creature {
    private static int numberFoxes = 3;
    private int damage;

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point point) {

    }

    public static int getNumberFoxes() {
        return numberFoxes;
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}