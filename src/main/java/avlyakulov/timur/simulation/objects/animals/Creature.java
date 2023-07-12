package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;

public abstract class Creature extends Entity {
    private int speed;
    private int hp;

    abstract void makeMove();
}