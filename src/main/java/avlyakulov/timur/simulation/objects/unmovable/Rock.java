package avlyakulov.timur.simulation.objects.unmovable;

import avlyakulov.timur.simulation.entity.Entity;

public class Rock extends Entity {
    private final int NUMBER_OF_ROCK = 4;


    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_ROCK;
    }
}
