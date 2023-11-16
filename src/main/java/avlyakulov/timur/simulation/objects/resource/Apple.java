package avlyakulov.timur.simulation.objects.resource;

import avlyakulov.timur.simulation.entity.Entity;

public class Apple extends Entity {

    @Override
    public String toString() {
        return "\uD83C\uDF4E";
    }

    @Override
    public int getNumberOfEntity() {
        return 4;
    }
}