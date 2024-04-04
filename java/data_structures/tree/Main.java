package data_structures.tree;

public class Main {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        Node child3 = new Node(4);
        Node child4 = new Node(5);

        root.setLeft(child1);
        root.setRight(child2);
        child1.setLeft(child3);
        child1.setRight(child4);

        Tree tree = new Tree();
        tree.traversePreOrder(root);
        System.out.println();
        tree.traverseInOrder(root);
        System.out.println();
        tree.traversePostOrder(root);
    }
}
