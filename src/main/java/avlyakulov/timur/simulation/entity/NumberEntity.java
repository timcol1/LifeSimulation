package avlyakulov.timur.simulation.entity;

public enum NumberEntity {
    APPLE(1),//4
    PIG(1),//4
    FOX(0),//2
    ROCK(4),//4
    TREE(0);//4

    private final int quantity;

    NumberEntity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}