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
    //todo отфиксить то что в конце все свиньи становятся в 1 клетку

    private final static int maxLengthX = 4;
    private final static int maxLengthY = 4;


    //как нужно сделать
    //1 Мы ищем ближайшего соседа
    // когда нашли его берем коллекцию already visited
    // и начинаем ее перебирать если мы можем стать туда

    public void gameStartSimulation() {
        GameMap gameMapUtil = new GameMap(maxLengthX, maxLengthY);
        //Map<Point, Entity> gameMap = gameMapUtil.fillMap();
        Map<Point, Entity> gameMap = new HashMap<>();
        gameMap.put(new Point(0,0), new Pig());
        gameMap.put(new Point(0,2), new Apple());
        System.out.println("Simulations begins");
        startSimulation(gameMapUtil, gameMap);
        System.out.println("The simulation is over");
    }


    public void wordSimulation(Map<Point, Entity> gameMap) {
        Point pointIterate;
        Point pointToMove = null;
        for (int i = 0; i < maxLengthX; ++i) {
            for (int j = 0; j < maxLengthY; ++j) {
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

    public Point forEntityCreatePointToMove(Point pointOfCreature, Map<Point, Entity> gameMap, Creature creature) {
        // 1 - it is Pig ; 2 - it is Fox
        int typeOfCreature = checkTypeOfCreature(creature);
        switch (typeOfCreature) {
            case 1 -> {
                return findPointForCreature(pointOfCreature, gameMap, Apple.class);
            }
            case 2 -> {
                return findPointForCreature(pointOfCreature, gameMap, Pig.class);
            }
            default -> throw new RuntimeException("Something went wrong in checking type of animal");
        }
    }

    public int checkTypeOfCreature(Creature creature) {
        return creature instanceof Pig ? 1 : 2;
    }

    public <T> Point findPointForCreature(Point pointOfCreature, Map<Point, Entity> gameMap, Class<T> targetOnTheMap) {
        List<Point> validNeighborsOfPoints = getValidNeighborsOfPoints(pointOfCreature, gameMap);
        Queue<Point> queue = new ArrayDeque<>(validNeighborsOfPoints);
        Queue<Point> alreadyVisited = new ArrayDeque<>();

        //идея реализации как искать нужный путь к нашей точки
        // представим что наша точка это 1 1 Искомая точка это 3 0
        //анализируем куда нужно двигаться 3 больше чем i, но 0 меньше чем 1 отсюда и можно обозначить куда двигаться
        // x, y - координаты искомой точки. i, j - текущие координаты существа которое хочет двигаться
        //y > j строго вправо ->
        //y < j строго вправо <-
        // y == j and x < i строго вверх
        // y == j and x > i строго вниз
        while (!queue.isEmpty()) {
            Point possiblePoint = queue.remove();
            Entity possibleEntity = gameMap.get(possiblePoint);
            if (gameMap.get(possiblePoint) != null && targetOnTheMap.isInstance(gameMap.get(possiblePoint))) {
                alreadyVisited.add(possiblePoint);
                Map<String, Point> validNeighborsOfPointInMapRepresentation = getValidNeighborsOfPointInMapRepresentation(pointOfCreature, gameMap);
                return choosePointForMoveFromDirections(pointOfCreature, possiblePoint, validNeighborsOfPointInMapRepresentation);
            } else {
                alreadyVisited.add(possiblePoint);
                validNeighborsOfPoints = getValidNeighborsOfPoints(possiblePoint, gameMap);
                queue.addAll(validNeighborsOfPoints);
                queue.removeAll(alreadyVisited);
            }
        }
        return null;
    }


    public List<Point> getNeighborsOfPoint(Point pointOfCreature) {
        //какой тут алгоритм определение соседей:
        //1) берем правого соседа
        //2) берем нижнего соседа
        //3) берем левого соседа
        //4) берем верхнего соседа
        Point point = new Point(pointOfCreature.getX(), pointOfCreature.getY() + 1);//вправо
        Point point2 = new Point(pointOfCreature.getX() + 1, pointOfCreature.getY());//вниз
        Point point3 = new Point(pointOfCreature.getX(), pointOfCreature.getY() - 1);//влево
        Point point4 = new Point(pointOfCreature.getX() - 1, pointOfCreature.getY());//вверх
        return List.of(point, point2, point3, point4);
    }

    public Map<String, Point> getValidNeighborsOfPointInMapRepresentation(Point start, Map<Point, Entity> gameMap) {
        //какой тут алгоритм определение соседей:
        //1) берем правого соседа
        //2) берем нижнего соседа
        //3) берем левого соседа
        //4) берем верхнего соседа
        Map<String, Point> neighborsWithDirections = new HashMap<>();
        List<Point> neighborsOfPoint = getNeighborsOfPoint(start);
        if (isPointPossible(neighborsOfPoint.get(0)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(0)), gameMap.get(start))) {
            neighborsWithDirections.put("right", neighborsOfPoint.get(0));
        }
        if (isPointPossible(neighborsOfPoint.get(1)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(1)), gameMap.get(start))) {
            neighborsWithDirections.put("down", neighborsOfPoint.get(1));
        }
        if (isPointPossible(neighborsOfPoint.get(2)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(2)), gameMap.get(start))) {
            neighborsWithDirections.put("left", neighborsOfPoint.get(2));
        }
        if (isPointPossible(neighborsOfPoint.get(3)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(3)), gameMap.get(start))) {
            neighborsWithDirections.put("up", neighborsOfPoint.get(3));
        }
        return neighborsWithDirections;
    }

    // x, y - координаты искомой точки. i, j - текущие координаты существа которое хочет двигаться
    //y > j строго вправо ->
    //y < j строго влево <-
    // y == j and x < i строго вверх
    // y == j and x > i строго вниз
    public Point choosePointForMoveFromDirections(Point start, Point toMove, Map<String, Point> neighbors) {
        if (toMove.getY() > start.getY()) {
            return choosePointWithDirection("right", neighbors);
        } else if (toMove.getY() < start.getY()) {
            return choosePointWithDirection("left", neighbors);
        } else if (toMove.getY() == start.getY() && toMove.getX() < start.getX()) {
            return choosePointWithDirection("up", neighbors);
        } else if (toMove.getY() == start.getY() && toMove.getX() > start.getX()) {
            return choosePointWithDirection("down", neighbors);
        } else {
            throw new RuntimeException("No path was chosen to go something went wrong...");
        }
    }

    public Point choosePointWithDirection(String direction, Map<String, Point> neighbors) {
        switch (direction) {
            case "right", "left", "up", "down" -> {
                Point point = neighbors.get(direction);
                //todo отфиксить для свиньи возможные пути как обойти препятствие
                if (point == null) {
                    List<Point> possibleNeighbors = new ArrayList<>(neighbors.values());
                    int size = possibleNeighbors.size();
                    Random random = new Random();
                    int randomPoint = random.nextInt(0, size);
                    return possibleNeighbors.get(randomPoint);
                } else {
                    return point;
                }
            }
            default -> throw new RuntimeException("No direction was given");
        }
    }


    public List<Point> getValidNeighborsOfPoints(Point pointOfCreature, Map<Point, Entity> gameMap) {
        List<Point> allNeighborsOfPoint = getNeighborsOfPoint(pointOfCreature);

        List<Point> validPoints = new ArrayList<>();

        for (Point point : allNeighborsOfPoint) {
            //todo тут основная проблема тут мы должны передать creature.class но тут проблема null вылетает
            if (isPointPossible(point) && isPointNotOccupied(gameMap.get(point), gameMap.get(pointOfCreature))) {
                validPoints.add(point);
            }
        }
        return validPoints;
    }


    public boolean isPointPossible(Point point) {
        return (point.getX() >= 0 && point.getY() >= 0 && point.getX() <= maxLengthX - 1 && point.getY() <= maxLengthY - 1);
    }

    public boolean isPointNotOccupied(Entity entity, Entity entityOnPoint) {
        //entity - это существо или не существо на точке
        //нам нужно в зависимости от нашего существа на начальной точки разделить куда надо идти
        //todo fix because fox can't find pig it skips it
        //todo отрефакторить этот метод и передумать его, никак нельзя сделать его гибким
        //todo нужно делать гибко, потому что добавим существ и как мы будем искать
        //todo проблема сейчас при null  у нас вылает ошибка null pointer exception

        if (entity instanceof Fox || entity instanceof Rock || entity instanceof Tree || entity instanceof Pig) {
            return false;
        } else {
            return true;
        }
    }


    public void startSimulation(GameMap gameMapUtil, Map<Point, Entity> gameMap) {
        Collection<Entity> entities = gameMap.values();
        gameMapUtil.printMap(gameMap);
        do {
            int counter = 0;
            for (Entity entity : entities) {
                if (entity instanceof Apple) {
                    ++counter;
                }
            }
            if (counter == 0) {
                break;
            } else {
                wordSimulation(gameMap);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                gameMapUtil.printMap(gameMap);
                System.out.println();
            }
        } while (true);
    }

}