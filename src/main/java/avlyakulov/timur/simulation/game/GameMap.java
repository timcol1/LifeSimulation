package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.entity.Fox;
import avlyakulov.timur.simulation.entity.Pig;
import avlyakulov.timur.simulation.entity.Apple;
import avlyakulov.timur.simulation.entity.Rock;
import avlyakulov.timur.simulation.entity.Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameMap {

    private final Random random = new Random();
    private final int maxLengthX;
    private final int maxLengthY;


    public GameMap(int maxLengthX, int maxLengthY) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
    }

    public Map<Point, Entity> fillMap() {
        Map<Point, Entity> gameMap = new HashMap<>();
        List<Entity> listEntities = getListEntities();
        for (Entity entity : listEntities) {
            fillEntityInGameMap(entity, gameMap);
        }
        return gameMap;
    }

    public void printMap(Map<Point, Entity> gameMap) {
        for (int x = 0; x < maxLengthX; ++x) {
            for (int y = 0; y < maxLengthY; ++y) {
                Point point = new Point(x, y);
                if (gameMap.containsKey(point))
                    System.out.printf("%s\t", gameMap.get(point));
                else {
                    System.out.print(".\t");
                }
            }
            System.out.println();
        }
    }

    private Point generatePointForSetCreatureToMap() {
        return new Point(random.nextInt(maxLengthX), random.nextInt(maxLengthY));
    }

    private List<Entity> getListEntities() {
        return List.of(new Fox(), new Pig(), new Apple(), new Rock(), new Tree());
    }

    private void fillEntityInGameMap(Entity entity, Map<Point, Entity> gameMap) {
        if (entity instanceof Pig pig) {
            addEntityToMap(pig, gameMap);
        } else if (entity instanceof Fox fox) {
            addEntityToMap(fox, gameMap);
        } else if (entity instanceof Apple apple) {
            addEntityToMap(apple, gameMap);
        } else if (entity instanceof Rock rock) {
            addEntityToMap(rock, gameMap);
        } else if (entity instanceof Tree tree) {
            addEntityToMap(tree, gameMap);
        }
    }

    public void addEntityToMap(Entity entity, Map<Point, Entity> gameMap) {
        int counter = 0;
        while (counter != entity.getNumberOfEntity()) {
            Point point = generatePointForSetCreatureToMap();
            if (!gameMap.containsKey(point)) {
                gameMap.put(point, entity);
                ++counter;
            }
        }
    }

}