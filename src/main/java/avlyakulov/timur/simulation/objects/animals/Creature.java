package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public abstract class Creature extends Entity {

    public abstract void makeMove(Map<Point, Entity> gameMap);
}