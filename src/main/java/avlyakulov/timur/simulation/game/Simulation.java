package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Entity;

import java.util.HashMap;
import java.util.Map;

public class Simulation {
    public static final String HERBIVORE = "\uD83D\uDC37";
    public static final String PREDATOR = "\uD83E\uDD8A";
    public static final String TREE = "\uD83C\uDF33";
    public static final String ROCK = "\uD83E\uDEA8";
    public static final String APPLE = "\uD83C\uDF4E";
    private Map<Integer, Entity> gameMap = new HashMap<>();

    public void gameFieldRender() {
        System.out.println("——————————————————");
        System.out.println(APPLE);
        System.out.println("——————————————————");
    }
}