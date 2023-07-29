package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Creature;

import javax.swing.*;
import java.util.Map;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(8, 8);
        Map<Point, Entity> gameMap = (Map<Point, Entity>) gameMapUtil.fillMap();
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("----------------------");
        gameMapUtil.printMap(gameMap);
    }


    public void wordSimulation(Map<Point, ? extends Entity> gameMap) {
        for (Map.Entry entry : gameMap.entrySet()) {
            if (entry.getValue() instanceof Creature creature) {
                creature.makeMove(gameMap, (Point) entry.getKey());
                break;
            }
        }

    }
}