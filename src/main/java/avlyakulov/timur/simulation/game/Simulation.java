package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Creature;

import java.util.Map;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(10, 10);
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

        for (Map.Entry<Point, Entity> entry : gameMap.entrySet()) {
            if (entry.getValue() instanceof Creature) {
                System.out.println(entry.getValue() + " his coordinate " + entry.getKey());
            }
        }
    }

    public Point forEntityCreatePointToMove(Map<Point, Entity> gameMap, Creature creature) {

        return null;
    }
}