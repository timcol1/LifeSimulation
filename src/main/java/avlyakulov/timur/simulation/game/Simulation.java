package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Creature;
import avlyakulov.timur.simulation.objects.animals.Fox;
import avlyakulov.timur.simulation.objects.animals.Pig;

import java.util.Map;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(8, 8);
        Map<Point, Entity> gameMap = (Map<Point, Entity>) gameMapUtil.fillMap();
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
    }


    public void wordSimulation(Map<Point, ? extends Entity> gameMap) {
        for (int i = 0; i < gameMap.size(); i++) {
            for (int j = 0; j < gameMap.size(); j++) {

            }
        }
    }
}