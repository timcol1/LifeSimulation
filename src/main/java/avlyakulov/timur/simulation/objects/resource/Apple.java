package avlyakulov.timur.simulation.objects.resource;

import avlyakulov.timur.simulation.entity.Entity;

public class Apple extends Entity {
    private final int NUMBER_OF_APPLE = 1;


    @Override
    public String toString() {
        return "\uD83C\uDF4E";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_APPLE;
    }
}