package avlyakulov.timur.simulation.game;

import avlyakulov.timur.simulation.entity.Point;

import java.util.*;

public class Node<T extends Point> {

    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public void connect(Node<T> node) {
        if (this == node) {
            throw new IllegalArgumentException("Can't connect node to itself");
        }
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    public static <T extends Point> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        Queue<Node<T>> alreadyVisited = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.println("Visited node with value: " + currentNode.getValue());

            if (value.equals(currentNode.getValue())) {
                System.out.println(alreadyVisited);
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }
        return Optional.empty();
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }
}