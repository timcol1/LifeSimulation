package avlyakulov.timur.simulation.objects.animals;

public class Fox extends Creature {
    private static int numberFoxes = 3;
    private int damage;

    @Override
    void makeMove() {

    }

    public static int getNumberFoxes() {
        return numberFoxes;
    }

    @Override
    public String toString() {
        return "\uD83E\uDD8A";
    }
}