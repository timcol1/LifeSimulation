package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Pig extends Creature {


    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point point) {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }

    @Override
    public int getNumberOfEntity() {
        return 4;
    }
}