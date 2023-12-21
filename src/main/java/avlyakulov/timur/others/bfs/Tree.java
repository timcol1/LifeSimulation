package avlyakulov.timur.others.bfs;

import java.util.*;

public class Tree<T> {
    private T value;
    private List<Tree<T>> children;

    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    //создание дерева на примере какого то элемента
    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }

    //добавления элемента в наше дерево
    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        this.children.add(newChild);
        return newChild;
    }

    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
            System.out.println("Our algorithm visited this node " + currentNode.getValue());
            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return Optional.empty();
    }

    public T getValue() {
        return this.value;
    }

    public List<Tree<T>> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {

    }
}