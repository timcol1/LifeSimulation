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
        children.add(newChild);
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
        return value;
    }

    public List<Tree<T>> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Tree<Integer> root = Tree.of(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> firstChildChild = rootFirstChild.addChild(3);
        Tree<Integer> firstChildChild1 = firstChildChild.addChild(5);
        Tree<Integer> rootSecondChild = root.addChild(4);
        Tree<Integer> child = rootSecondChild.addChild(6);
        Optional<Tree<Integer>> search = Tree.search(4, root);
        System.out.println(search.get().getChildren());


    }
}