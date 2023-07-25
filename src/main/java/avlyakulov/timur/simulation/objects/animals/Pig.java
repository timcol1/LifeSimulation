package avlyakulov.timur.simulation.objects.animals;

public class Pig extends Creature {
    public static final String PIG_ICON = "\uD83D\uDC37";
    private int damage;

    @Override
    void makeMove() {

    }

    public String getPigIcon() {
        return PIG_ICON;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }
}
