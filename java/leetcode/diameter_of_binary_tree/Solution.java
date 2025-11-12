package leetcode.diameter_of_binary_tree;

class Tree {
    int val;
    Tree left;
    Tree right;

    public Tree(int val, Tree left, Tree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int maxDepth = 0;

    private int dfs(Tree node, int depth) {
        if (node == null) {
            return depth;
        }
        int leftDepth = dfs(node.left, depth);
        int rightDepth = dfs(node.right, depth);
        maxDepth = Math.max(maxDepth, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int diameterOfBinaryTree(Tree root) {
        dfs(root, 0);
        return maxDepth;
    }
}
