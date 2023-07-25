package avlyakulov.timur.simulation.objects.unmovable;

import avlyakulov.timur.simulation.entity.Entity;

public class Tree extends Entity {

    private static int numberTrees = 5;

    public static int getNumberTrees() {
        return numberTrees;
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }
}
