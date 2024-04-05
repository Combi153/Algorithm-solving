package baekjoon.no1991_트리_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static class Tree {
        Node root;

        public Tree() {
            this.root = null;
        }

        static class Node {
            String data;
            Node left;
            Node right;

            public Node(String data) {
                this.data = data;
            }

            public Node(String data, Node left, Node right) {
                this.data = data;
                this.left = left;
                this.right = right;
            }
        }

        public void insertNode(String data, String leftData, String rightData) {
            if (root == null) {
                Node left = Objects.equals(leftData, ".") ? null : new Node(leftData);
                Node right = Objects.equals(rightData, ".") ? null : new Node(rightData);
                root = new Node(data, left, right);
                return;
            }
            findAndAddNode(root, data, leftData, rightData);
        }

        private void findAndAddNode(Node node, String data, String leftData, String rightData) {
            if (Objects.equals(node.data, data)) {
                node.left = Objects.equals(leftData, ".") ? null : new Node(leftData);
                node.right = Objects.equals(rightData, ".") ? null : new Node(rightData);
                return;
            }
            if (node.left != null) {
                findAndAddNode(node.left, data, leftData, rightData);
            }
            if (node.right != null) {
                findAndAddNode(node.right, data, leftData, rightData);
            }
        }

        public void traversePreOrder() {
            traversePreOrder(root);
        }

        private void traversePreOrder(Node node) {
            System.out.print(node.data);
            if (node.left != null) {
                traversePreOrder(node.left);
            }
            if (node.right != null) {
                traversePreOrder(node.right);
            }
        }

        public void traverseInOrder() {
            traverseInOrder(root);
        }

        private void traverseInOrder(Node node) {
            if (node.left != null) {
                traverseInOrder(node.left);
            }
            System.out.print(node.data);
            if (node.right != null) {
                traverseInOrder(node.right);
            }
        }

        public void traversePostOrder() {
            traversePostOrder(root);
        }

        private void traversePostOrder(Node node) {
            if (node.left != null) {
                traversePostOrder(node.left);
            }
            if (node.right != null) {
                traversePostOrder(node.right);
            }
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nc = Integer.parseInt(br.readLine());
        Tree tree = new Tree();

        for (int i = 0; i < nc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String value = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            tree.insertNode(value, left, right);
        }

        tree.traversePreOrder();
        System.out.println();
        tree.traverseInOrder();
        System.out.println();
        tree.traversePostOrder();
    }
}
