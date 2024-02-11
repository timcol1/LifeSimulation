package avlyakulov.timur.simulation.entity;

public class Tree extends Entity {
    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.TREE.getQuantity();
    }
}
