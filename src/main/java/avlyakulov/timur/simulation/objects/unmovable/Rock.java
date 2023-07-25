package avlyakulov.timur.simulation.objects.unmovable;

import avlyakulov.timur.simulation.entity.Entity;

public class Rock extends Entity {

    private static int numberRocks = 6;

    public static int getNumberRocks() {
        return numberRocks;
    }

    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }
}
