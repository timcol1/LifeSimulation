package avlyakulov.timur.simulation.entity;

public class Tree extends Entity {
    private final int NUMBER_OF_TREE = 4;
    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_TREE;
    }
}
