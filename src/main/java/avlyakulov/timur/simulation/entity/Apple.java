package avlyakulov.timur.simulation.entity;

public class Apple extends Entity {


    @Override
    public String toString() {
        return "\uD83C\uDF4E";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.APPLE.getQuantity();
    }
}