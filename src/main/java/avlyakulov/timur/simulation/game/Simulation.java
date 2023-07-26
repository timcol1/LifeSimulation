package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Simulation {


    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(8,8);
        Map<Point, Entity> gameMap = gameMapUtil.fillMap();
        gameMapUtil.printMap(gameMap);
    }
}