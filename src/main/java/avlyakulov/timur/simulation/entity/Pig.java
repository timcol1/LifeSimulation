package avlyakulov.timur.simulation.entity;

import avlyakulov.timur.simulation.game.GameMap;

import java.util.Map;

public class Pig extends Creature {


    @Override
    public void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        GameMap.makeMove(gameMap, pointIterate, pointToMove);
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.PIG.getQuantity();
    }

    public Class<Apple> getTargetEntityClass() {
        return Apple.class;
    }
}