package avlyakulov.timur.simulation.entity;

import java.util.Map;

public class Fox extends Creature {


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
        return NumberEntity.FOX.getQuantity();
    }
}