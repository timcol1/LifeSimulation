package avlyakulov.timur.simulation.objects.unmovable;

import avlyakulov.timur.simulation.entity.Entity;

public class Tree extends Entity {

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }

    @Override
    public int getNumberOfEntity() {
        return 5;
    }
}
