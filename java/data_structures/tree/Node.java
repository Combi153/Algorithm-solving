package data_structures.tree;

public class Node {
    private final int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Node left() {
        return left;
    }

    public Node right() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
