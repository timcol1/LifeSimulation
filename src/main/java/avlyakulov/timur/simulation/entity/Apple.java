package avlyakulov.timur.simulation.entity;

public class Apple extends Entity {
    private final int NUMBER_OF_APPLE = 4;


    @Override
    public String toString() {
        return "\uD83C\uDF4E";
    }

    @Override
    public int getNumberOfEntity() {
        return NUMBER_OF_APPLE;
    }
}