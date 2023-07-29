package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Pig extends Creature {
    private int damage;

    private static int numberPigs = 4;

    @Override
    void makeMove(Map<Point, Entity> gameMap) {
        for (Entity entity : gameMap.values()) {
            if (entity instanceof Pig) {

            }
        }
    }

    public static int getNumberPigs() {
        return numberPigs;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }
}
