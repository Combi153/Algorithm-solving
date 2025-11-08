/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    // dfs
    function dfs(node) {
        if (node === null) {
            return [true, 0];
        }

        const [isLeftHeightBalanced, leftHeight] = dfs(node.left);
        const [isRightHeightBalanced, rightHeight] = dfs(node.right);

        const isHeightBalanced = isLeftHeightBalanced && isRightHeightBalanced && Math.abs(leftHeight - rightHeight) <= 1;

        return [isHeightBalanced, 1 + Math.max(rightHeight, leftHeight)];
    }

    return dfs(root)[0];
};