package avlyakulov.timur.simulation.entity;

public enum NumberEntity {
    APPLE(4),
    PIG(4),
    FOX(2),
    ROCK(4),
    TREE(4);

    private final int quantity;

    NumberEntity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}