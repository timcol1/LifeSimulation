package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;
import avlyakulov.timur.simulation.entity.Point;
import avlyakulov.timur.simulation.objects.animals.Creature;
import avlyakulov.timur.simulation.objects.animals.Fox;
import avlyakulov.timur.simulation.objects.animals.Pig;
import avlyakulov.timur.simulation.objects.resource.Apple;
import avlyakulov.timur.simulation.objects.unmovable.Rock;
import avlyakulov.timur.simulation.objects.unmovable.Tree;

import java.util.*;

public class Simulation {

    private final static int maxLengthX = 3;
    private final static int maxLengthY = 3;


    //как нужно сделать
    //1 Мы ищем ближайшего соседа
    // когда нашли его берем коллекцию allready visited
    // и начинаем ее перебирать если мы можем стать туда

    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(maxLengthX, maxLengthY);
        //Map<Point, Entity> gameMap = gameMapUtil.fillMap();
        Map<Point, Entity> gameMap = new HashMap<>();
        gameMap.put(new Point(0, 0), new Pig());
        gameMap.put(new Point(2, 2), new Apple());
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("--------------------------------------");
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("--------------------------------------");
        gameMapUtil.printMap(gameMap);
        wordSimulation(gameMap);
        System.out.println("--------------------------------------");
        gameMapUtil.printMap(gameMap);
    }


    //todo на 27.12 Доделать поиск существа, сейчас наше существо ищет яблоко, но на предпоследней итерации
    //оно не ищет до конца, останавливается отфиксить
    public void wordSimulation(Map<Point, Entity> gameMap) {
        Point pointIterate;
        Point pointToMove = null;
        for (int i = 0; i < gameMap.size(); ++i) {
            for (int j = 0; j < gameMap.size(); ++j) {
                pointIterate = new Point(i, j);

                if (pointIterate.equals(pointToMove))
                    continue;

                Entity entity = gameMap.get(pointIterate);
                if (entity instanceof Creature creature) {
                     pointToMove = forEntityCreatePointToMove(pointIterate, gameMap, creature);
                    creature.makeMove(gameMap, pointIterate, pointToMove);
                }
            }
        }
    }

    public Point forEntityCreatePointToMove(Point start, Map<Point, Entity> gameMap, Creature creature) {
        // 1 - it is Pig ; 2 - it is Fox
        int typeOfCreature = checkTypeOfCreature(creature);
        switch (typeOfCreature) {
            case 1 -> {
                return findPointForPig(start, gameMap);
            }
            case 2 -> {
                return findPointForFox(start, gameMap);
            }
            default -> throw new RuntimeException("Something went wrong in checking type of animal");
        }
    }

    public int checkTypeOfCreature(Creature creature) {
        return creature instanceof Pig ? 1 : 2;
    }

    public Point findPointForPig(Point start, Map<Point, Entity> gameMap) {
        List<Point> points = getNeighborsOfPoint(start, gameMap);
        Queue<Point> queue = new ArrayDeque<>(points);
        Queue<Point> alreadyVisited = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            Point possiblePoint = queue.remove();
            if (gameMap.get(possiblePoint) instanceof Apple) {
                int a = 12;
                return alreadyVisited.remove();
            } else {
                alreadyVisited.add(possiblePoint);
                List<Point> neighborsOfPoint = getNeighborsOfPoint(possiblePoint, gameMap);
                queue.addAll(neighborsOfPoint);
                queue.removeAll(alreadyVisited);
            }
        }

        return null;
    }

    public List<Point> getNeighborsOfPoint(Point start, Map<Point, Entity> gameMap) {
        Point point = new Point(start.getX(), start.getY() + 1);
        Point point2 = new Point(start.getX() + 1, start.getY());
        Point point3 = new Point(start.getX() - 1, start.getY());
        Point point4 = new Point(start.getX(), start.getY() - 1);
        List<Point> points = List.of(point, point2, point3, point4);
        return getValidNeighborsOfPoints(points, gameMap);
    }

    public List<Point> getValidNeighborsOfPoints(List<Point> points, Map<Point, Entity> gameMap) {
        List<Point> validPoints = new ArrayList<>();

        for (Point point : points) {
            if (isPointPossible(point) && isPointNotOccupied(point, gameMap)) {
                validPoints.add(point);
            }
        }
        return validPoints;
    }


    public Point findPointForFox(Point start, Map<Point, Entity> gameMap) {
        return null;
    }

    public boolean isPointPossible(Point point) {
        return (point.getX() >= 0 && point.getY() >= 0 && point.getX() <= maxLengthX - 1 && point.getY() <= maxLengthY - 1);
    }

    public boolean isPointNotOccupied(Point point, Map<Point, Entity> gameMap) {
        Entity entity = gameMap.get(point);
        if (entity instanceof Fox || entity instanceof Rock || entity instanceof Tree || entity instanceof Pig) {
            return false;
        } else {
            return true;
        }
    }

}