package avlyakulov.timur.simulation.objects.animals;

public class Pig extends Creature {
    private int damage;

    private static int numberPigs = 4;

    @Override
    void makeMove() {

    }

    public static int getNumberPigs() {
        return numberPigs;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }
}
