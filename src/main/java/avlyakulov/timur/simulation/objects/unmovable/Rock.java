package avlyakulov.timur.simulation.objects.unmovable;

import avlyakulov.timur.simulation.entity.Entity;

public class Rock extends Entity {

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }

    @Override
    public int getNumberOfEntity() {
        return 6;
    }
}
