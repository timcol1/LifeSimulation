package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameMap {

    private Map<Point, Entity> gameMap;
    private final Random random = new Random();
    private final int maxLengthX;
    private final int maxLengthY;


    public GameMap(int maxLengthX, int maxLengthY) {
        this.maxLengthX = maxLengthX;
        this.maxLengthY = maxLengthY;
    }

    public void fillMap() {
        gameMap = new HashMap<>();
        List<Entity> listEntities = getListEntities();
        for (Entity entity : listEntities) {
            fillEntityInGameMap(entity);
        }
    }

    public void fillMap(Map<Point, Entity> filledGameMap) {
        gameMap = new HashMap<>(filledGameMap);
    }

    public Map<Point, Entity> getGameMap() {
        return gameMap;
    }

    public void printMap() {
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

    private void fillEntityInGameMap(Entity entity) {
        if (entity instanceof Pig pig) {
            addEntityToMap(pig);
        } else if (entity instanceof Fox fox) {
            addEntityToMap(fox);
        } else if (entity instanceof Apple apple) {
            addEntityToMap(apple);
        } else if (entity instanceof Rock rock) {
            addEntityToMap(rock);
        } else if (entity instanceof Tree tree) {
            addEntityToMap(tree);
        }
    }

    public void addEntityToMap(Entity entity) {
        int counter = 0;
        while (counter != entity.getNumberOfEntity()) {
            Point point = generatePointForSetCreatureToMap();
            if (!gameMap.containsKey(point)) {
                gameMap.put(point, entity);
                ++counter;
            }
        }
    }

    public static void makeMove(Map<Point, Entity> gameMap, Point pointIterate, Point pointToMove) {
        if (!pointIterate.equals(pointToMove)) {
            Creature creature = (Creature) gameMap.get(pointIterate);
            Entity entityOnPoint = gameMap.get(pointToMove);
            Class<? extends Entity> targetEntity = creature.getTargetEntityClass();
            if (targetEntity.isInstance(entityOnPoint)) {
                gameMap.remove(pointToMove);
            }
            gameMap.put(pointToMove, creature);
            gameMap.remove(pointIterate);
        }
    }
}