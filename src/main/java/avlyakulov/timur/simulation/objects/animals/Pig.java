package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.resource.Apple;

import java.util.Map;

public class Pig extends Creature {
    private final int NUMBER_OF_PIG = 1;

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        Entity pig = gameMap.get(pointIterate);
        Entity entityOnPoint = gameMap.get(pointToMove);
        if (entityOnPoint instanceof Apple) {
            gameMap.remove(pointToMove);
        }
        gameMap.put(pointToMove, pig);
        gameMap.remove(pointIterate);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_PIG;
    }
}