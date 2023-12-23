package avlyakulov.timur.others.bfs.tree;

import java.util.*;

public class TreeOwn<T> {

    private T value;

    private List<TreeOwn<T>> children;

    public TreeOwn(T value) {
        this.value = value;
    }

    public static <T> TreeOwn<T> of(T value) {
        TreeOwn<T> newTree = new TreeOwn<>(value);
        newTree.children = new ArrayList<>();
        return newTree;
    }

    @SafeVarargs
    public final void addChildren(TreeOwn<T>... children) {
        this.children.addAll(Arrays.asList(children));
    }

    //bfs in tree
    public static <T> Optional<TreeOwn<T>> findTreeByValue(T value, TreeOwn<T> root) {
        Queue<TreeOwn<T>> queue = new ArrayDeque<>();
        queue.add(root);
        if (root == null) {
            System.out.println("This tree is empty");
        } else {
            while (!queue.isEmpty()) {
                TreeOwn<T> tree = queue.poll();
                System.out.println("Visited tree " + tree.getValue());
                if (tree.getValue().equals(value)) {
                    return Optional.of(tree);
                } else {
                    queue.addAll(tree.getChildren());
                }
            }
        }
        return Optional.empty();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeOwn<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeOwn<T>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeOwn{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }

    public static void main(String[] args) {
        TreeOwn<Integer> rootTree = TreeOwn.of(12);
        TreeOwn<Integer> childTree = TreeOwn.of(13);
        TreeOwn<Integer> childTree1 = TreeOwn.of(14);
        TreeOwn<Integer> childTree2 = TreeOwn.of(15);
        TreeOwn<Integer> childTree3 = TreeOwn.of(16);
        TreeOwn<Integer> childChildTree1 = TreeOwn.of(17);
        childTree1.addChildren(childChildTree1);
        rootTree.addChildren(childTree, childTree1, childTree2, childTree3);

        Optional<TreeOwn<Integer>> treeByValue = TreeOwn.findTreeByValue(17, rootTree);
        treeByValue.ifPresent(System.out::println);
    }
}