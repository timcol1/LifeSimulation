package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.resource.Apple;

import java.util.Map;

public class Fox extends Creature {

    private final int NUMBER_OF_FOX = 0;

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        Entity fox = gameMap.get(pointIterate);
        Entity entityOnPoint = gameMap.get(pointToMove);
        if (entityOnPoint instanceof Pig) {
            gameMap.remove(pointToMove);
        }
        gameMap.put(pointToMove, fox);
        gameMap.remove(pointIterate);
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