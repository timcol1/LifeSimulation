package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.*;

import java.util.*;

public class Simulation {

    private final static int maxLengthX = 3;
    private final static int maxLengthY = 3;

    private GameMap gameMapUtil;


    //как нужно сделать
    //1 Мы ищем ближайшего соседа
    // когда нашли его берем коллекцию already visited
    // и начинаем ее перебирать если мы можем стать туда

    public void gameStartSimulation() {
        gameMapUtil = new GameMap(maxLengthX, maxLengthY);
        //gameMapUtil.fillMap();
        Map<Point, Entity> rockIsUp = Map.of(new Point(2, 2), new Pig(), new Point(1, 1), new Rock(), new Point(0, 1), new Apple());
        Map<Point, Entity> rockIsRight = Map.of(new Point(0, 0), new Pig(), new Point(0, 1), new Rock(), new Point(0, 2), new Apple());
        Map<Point, Entity> rockIsDown = Map.of(new Point(0, 1), new Pig(), new Point(1, 1), new Rock(), new Point(2, 1), new Apple());
        Map<Point, Entity> rockIsLeft = Map.of(new Point(0, 2), new Pig(), new Point(0, 1), new Rock(), new Point(0, 0), new Apple());
        gameMapUtil.fillMap(rockIsUp);
        System.out.println("Simulations begins");
        startSimulation(gameMapUtil);
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
        TypeOfCreature typeOfCreature = checkTypeOfCreature(creature);
        switch (typeOfCreature) {
            case PIG -> {
                return findPointForCreature(pointOfCreature, gameMap, Apple.class);
            }
            case FOX -> {
                return findPointForCreature(pointOfCreature, gameMap, Pig.class);
            }
            default -> throw new RuntimeException("Something went wrong in checking type of animal");
        }
    }

    public TypeOfCreature checkTypeOfCreature(Creature creature) {
        return creature instanceof Pig ? TypeOfCreature.PIG : TypeOfCreature.FOX;
    }

    public <T> Point findPointForCreature(Point pointOfCreature, Map<Point, Entity> gameMap, Class<T> targetOnTheMap) {
        List<Point> validNeighborsOfPoints = getValidNeighborsOfPoints(pointOfCreature, gameMap, targetOnTheMap);
        Queue<Point> queue = new ArrayDeque<>(validNeighborsOfPoints);
        Queue<Point> alreadyVisited = new ArrayDeque<>();

        //идея реализации как искать нужный путь к нашей точки
        //представим что наша точка это 1 1 искомая точка это 3 0
        //анализируем куда нужно двигаться 3 больше чем i, но 0 меньше чем 1 отсюда и можно обозначить куда двигаться
        // x, y - координаты искомой точки. i, j - текущие координаты существа которое хочет двигаться
        //y > j строго вправо ->
        //y < j строго вправо <-
        // y == j and x < i строго вверх
        // y == j and x > i строго вниз
        while (!queue.isEmpty()) {
            Point possiblePoint = queue.remove();
            if (gameMap.get(possiblePoint) != null && targetOnTheMap.isInstance(gameMap.get(possiblePoint))) {
                alreadyVisited.add(possiblePoint);
                Map<String, Point> validNeighborsOfPointInMapRepresentation = getValidNeighborsOfPointInMapRepresentation(pointOfCreature, gameMap, targetOnTheMap);
                return choosePointForMoveFromDirections(pointOfCreature, possiblePoint, validNeighborsOfPointInMapRepresentation);
            } else {
                alreadyVisited.add(possiblePoint);
                validNeighborsOfPoints = getValidNeighborsOfPoints(possiblePoint, gameMap, targetOnTheMap);
                queue.addAll(validNeighborsOfPoints);
                queue.removeAll(alreadyVisited);
            }
        }
        return pointOfCreature;
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

    public <T> Map<String, Point> getValidNeighborsOfPointInMapRepresentation(Point start, Map<Point, Entity> gameMap, Class<T> targetOnTheMap) {
        //какой тут алгоритм определение соседей:
        //1) берем правого соседа
        //2) берем нижнего соседа
        //3) берем левого соседа
        //4) берем верхнего соседа
        Map<String, Point> neighborsWithDirections = new HashMap<>();
        List<Point> neighborsOfPoint = getNeighborsOfPoint(start);
        if (isPointPossible(neighborsOfPoint.get(0)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(0)), targetOnTheMap)) {
            neighborsWithDirections.put("right", neighborsOfPoint.get(0));
        }
        if (isPointPossible(neighborsOfPoint.get(1)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(1)), targetOnTheMap)) {
            neighborsWithDirections.put("down", neighborsOfPoint.get(1));
        }
        if (isPointPossible(neighborsOfPoint.get(2)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(2)), targetOnTheMap)) {
            neighborsWithDirections.put("left", neighborsOfPoint.get(2));
        }
        if (isPointPossible(neighborsOfPoint.get(3)) && isPointNotOccupied(gameMap.get(neighborsOfPoint.get(3)), targetOnTheMap)) {
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
        } else if (toMove.getY() <= start.getY()) {
            return choosePointWithDirection("up", neighbors);
        } else if (toMove.getY() >= start.getY()) {
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


    public <T> List<Point> getValidNeighborsOfPoints(Point pointOfCreature, Map<Point, Entity> gameMap, Class<T> targetOnTheMap) {
        List<Point> allNeighborsOfPoint = getNeighborsOfPoint(pointOfCreature);

        List<Point> validPoints = new ArrayList<>();

        for (Point point : allNeighborsOfPoint) {
            if (isPointPossible(point) && isPointNotOccupied(gameMap.get(point), targetOnTheMap)) {
                validPoints.add(point);
            }
        }
        return validPoints;
    }


    public boolean isPointPossible(Point point) {
        return (point.getX() >= 0 && point.getY() >= 0 && point.getX() <= maxLengthX - 1 && point.getY() <= maxLengthY - 1);
    }

    public <T> boolean isPointNotOccupied(Entity entity, Class<T> targetOnTheMap) {
        //entity - это существо или не существо на точке
        //нам нужно в зависимости от нашего существа на начальной точки разделить куда надо идти
        if (entity == null) {
            return true;
        } else {
            return targetOnTheMap.isInstance(entity);
        }
    }


    public void startSimulation(GameMap gameMapUtil) {
        Collection<Entity> entities = gameMapUtil.getGameMap().values();
        gameMapUtil.printMap();
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
                wordSimulation(gameMapUtil.getGameMap());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                gameMapUtil.printMap();
                System.out.println();
            }
        } while (true);
    }
}