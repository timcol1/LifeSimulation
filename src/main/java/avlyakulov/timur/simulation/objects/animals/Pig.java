package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Pig extends Creature {

    private final static int numberPigs = 4;

    public static int getNumberPigs() {
        return numberPigs;
    }

    @Override
    public void makeMove(Map<Point, Entity> gameMap) {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }
}