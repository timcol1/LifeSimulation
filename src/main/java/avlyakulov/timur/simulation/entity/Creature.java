package avlyakulov.timur.simulation.entity;

import java.util.Map;

public abstract class Creature extends Entity {

    public abstract void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove);

    public abstract Class<? extends Entity> getTargetEntityClass();
}