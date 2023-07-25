package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;

import java.util.Map;

public class Simulation {


    public void gameFieldRender() {
        Map<Point, Entity> gameMap = new GameMap(4, 4).fillMap();
        System.out.println(gameMap);
    }
}