package avlyakulov.timur.simulation.objects.animals;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.List;
import java.util.Map;

public class Pig extends Creature {
    private int damage;

    private static int numberPigs = 4;

    public static int getNumberPigs() {
        return numberPigs;
    }

    @Override
    public void makeMove(Map<Point, ? extends Entity> gameMap, Point point) {
        Point point1 = new Point(point.getX(), point.getY() + 1);
        if (!gameMap.containsKey(point1)) {
            makeMoveHelper(gameMap, point, point1);
            gameMap.remove(point);
        }
    }

    private <T extends Entity> void makeMoveHelper(Map<Point, T> gameMap, Point point, Point point1) {
        gameMap.put(point1, gameMap.get(point));
    }

    @Override
    public String toString() {
        return "\uD83D\uDC37";
    }


}
