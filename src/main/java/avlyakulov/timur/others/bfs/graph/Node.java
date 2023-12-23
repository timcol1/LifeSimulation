package avlyakulov.timur.others.bfs.graph;

import java.util.*;

public class Node<T> {

    private T value;
    private Set<Node<T>> neighbors;

    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public void connect(Node<T> node) {
        if (this == node)
            throw new IllegalArgumentException("Can't connect node to itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    static class BreadthFirstSearchAlgorithm {
        public static <T> Optional<Node<T>> search(T value, Node<T> start) {
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
    }

    public static void main(String[] args) {
        Node<Integer> start = new Node<>(10);
        Node<Integer> firstNeighbor = new Node<>(2);
        start.connect(firstNeighbor);

        Node<Integer> firstNeighborNeighbor = new Node<>(3);
        firstNeighborNeighbor.connect(firstNeighbor);
        firstNeighborNeighbor.connect(start);
        Node<Integer> secondNeighbor = new Node<>(4);
        start.connect(secondNeighbor);

        BreadthFirstSearchAlgorithm.search(2, start);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public T getValue() {
        return value;
    }

    public Set<Node<T>> getNeighbors() {
        return neighbors;
    }
}