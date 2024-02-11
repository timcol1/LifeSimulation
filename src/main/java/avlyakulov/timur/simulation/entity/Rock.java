package avlyakulov.timur.simulation.entity;

public class Rock extends Entity {


    @Override
    public String toString() {
        return "\uD83E\uDEA8";
    }

    @Override
    public int getNumberOfEntity() {
        return NumberEntity.ROCK.getQuantity();
    }
}
