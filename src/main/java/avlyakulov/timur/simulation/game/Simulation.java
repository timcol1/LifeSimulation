package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Creature;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(4, 4);
        Map<Point, Entity> gameMap = gameMapUtil.fillMap();
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("--------------------------------------");
        gameMapUtil.printMap(gameMap);
    }


    public void wordSimulation(Map<Point, Entity> gameMap) {
        for (Entity entity : gameMap.values()) {
            if (entity instanceof Creature creature) {

                Point point = forEntityCreatePointToMove(gameMap, creature);
                creature.makeMove(gameMap, point);
            }
        }
    }

    public Point forEntityCreatePointToMove(Map<Point, Entity> gameMap, Creature creature) {
        Queue<Point> visited = new ArrayDeque<>();

        return null;
    }
}