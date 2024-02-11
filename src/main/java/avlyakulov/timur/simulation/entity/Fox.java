package avlyakulov.timur.simulation.entity;

import avlyakulov.timur.simulation.game.GameMap;

import java.util.Map;

public class Fox extends Creature {

    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        GameMap.makeMove(gameMap, pointIterate, pointToMove);
    }


    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.FOX.getQuantity();
    }

    @Override
    public Class<Pig> getTargetEntityClass() {
        return Pig.class;
    }
}