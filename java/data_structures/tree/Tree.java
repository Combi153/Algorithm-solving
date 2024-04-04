package data_structures.tree;

public class Tree {

    public void traverseInOrder(Node node) {
        if (node.left() != null) {
            traverseInOrder(node.left());
        }
        System.out.print(node.value() + " ");
        if (node.right() != null) {
            traverseInOrder(node.right());
        }
    }

    public void traversePreOrder(Node node) {
        System.out.print(node.value() + " ");
        if (node.left() != null) {
            traversePreOrder(node.left());
        }
        if (node.right() != null) {
            traversePreOrder(node.right());
        }
    }

    public void traversePostOrder(Node node) {
        if (node.left() != null) {
            traversePostOrder(node.left());
        }
        if (node.right() != null) {
            traversePostOrder(node.right());
        }
        System.out.print(node.value() + " ");
    }
}
