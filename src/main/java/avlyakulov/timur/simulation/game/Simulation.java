package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Pig;

import java.util.Iterator;
import java.util.Map;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(8, 8);
        Map<Point, Entity> gameMap = gameMapUtil.fillMap();
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("----------------------");
        gameMapUtil.printMap(gameMap);
    }


    public void wordSimulation(Map<Point, Entity> gameMap) {
        for (int i = 0; i < gameMap.size(); ++i) {
            for (int j = 0; j < gameMap.size(); j++) {
                if (gameMap.get(new Point(i, j)) instanceof Pig pig) {
                    pig.makeMove(gameMap, new Point(i, j));
                    ++j;
                }
            }
        }

    }
}