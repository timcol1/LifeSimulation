package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Fox extends Creature {

    private final int NUMBER_OF_FOX = 3;

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point point) {

    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_FOX;
    }
}