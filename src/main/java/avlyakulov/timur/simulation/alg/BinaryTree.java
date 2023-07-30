package avlyakulov.timur.simulation.alg;

public class BinaryTree {
    Node root;

    public Node addRecursiveToTree(Node current, int value) {
        if (current == null) {
            return new Node(value);//когда текущий узел равен нулю, мы достигли
            // конечного узла и можем вставить новый узел в эту позицию.
        }
        if (value < current.value) {
            current.left = addRecursiveToTree(current.left, value);//если наш вставляемый узел меньше корня
        } else if (value > current.value) {
            current.right = addRecursiveToTree(current.right, value); //если больше
        } else {
            return current;//if this value is exists
        }

        return current;
    }

    public void add(int value) {
        root = addRecursiveToTree(root, value);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(12);
        binaryTree.add(13);
        binaryTree.add(1);
        binaryTree.add(2);
        System.out.println(binaryTree);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
