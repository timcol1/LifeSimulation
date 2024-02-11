package avlyakulov.timur.simulation.entity;

import java.util.Map;

public class Pig extends Creature {

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        if (!pointIterate.equals(pointToMove)) {
            Entity pig = gameMap.get(pointIterate);
            Entity entityOnPoint = gameMap.get(pointToMove);
            if (entityOnPoint instanceof Apple) {
                gameMap.remove(pointToMove);
            }
            gameMap.put(pointToMove, pig);
            gameMap.remove(pointIterate);
        }
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.PIG.getQuantity();
    }
}