package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Fox;
import avlyakulov.timur.simulation.objects.animals.Pig;
import avlyakulov.timur.simulation.objects.resource.Apple;
import avlyakulov.timur.simulation.objects.unmovable.Rock;
import avlyakulov.timur.simulation.objects.unmovable.Tree;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameMap {
    private Random random = new Random();
    private int maxLengthX;
    private int maxLengthY;


    public GameMap(int maxLengthX, int maxLengthY) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
    }

    public Map<Point, Entity> fillMap() {
        Map<Point, Entity> gameMap = new HashMap<>();
        List<Entity> listEntities = List.of(new Fox(), new Pig(), new Apple(), new Rock(), new Tree());
        for (Entity entity : listEntities) {
            if (entity instanceof Fox) {
                for (int i = 0; i < Fox.getNumberFoxes(); ++i) {
                    int x = random.nextInt(maxLengthX);
                    int y = random.nextInt(maxLengthY);
                    if (!gameMap.containsKey(new Point(x, y))) {
                        gameMap.put(new Point(x, y), entity);
                    }
                }
            } else if (entity instanceof Pig) {
                for (int i = 0; i < Pig.getNumberPigs(); i++) {
                    int x = random.nextInt(maxLengthX);
                    int y = random.nextInt(maxLengthY);
                    if (!gameMap.containsKey(new Point(x, y))) {
                        gameMap.put(new Point(x, y), entity);
                    }
                }
            } else if (entity instanceof Apple) {
                for (int i = 0; i < Apple.getNumberApples(); ++i) {
                    int x = random.nextInt(maxLengthX);
                    int y = random.nextInt(maxLengthY);
                    if (!gameMap.containsKey(new Point(x, y))) {
                        gameMap.put(new Point(x, y), entity);
                    }
                }
            } else if (entity instanceof Rock) {
                for (int i = 0; i < Rock.getNumberRocks(); ++i) {
                    int x = random.nextInt(maxLengthX);
                    int y = random.nextInt(maxLengthY);
                    if (!gameMap.containsKey(new Point(x, y))) {
                        gameMap.put(new Point(x, y), entity);
                    }
                }
            } else if (entity instanceof Tree) {
                for (int i = 0; i < Tree.getNumberTrees(); ++i) {
                    int x = random.nextInt(maxLengthX);
                    int y = random.nextInt(maxLengthY);
                    if (!gameMap.containsKey(new Point(x, y))) {
                        gameMap.put(new Point(x, y), entity);
                    }
                }
            }
        }
        return gameMap;
    }

    public void printMap(Map<Point, Entity> gameMap) {
        for (int i = 0; i < maxLengthX; ++i) {
            for (int j = 0; j < maxLengthY; ++j) {
                if (gameMap.containsKey(new Point(i, j)))
                    System.out.printf("%s\t", gameMap.get(new Point(i, j)));
                else {
                    System.out.print(".\t");
                }
            }
            System.out.println();
        }
    }
}