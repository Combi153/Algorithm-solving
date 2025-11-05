/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @param {TreeNode} q
 * @return {TreeNode}
 */
var lowestCommonAncestor = function (root, p, q) {
  let node = root;
  while (node !== null) {
    if (p.val > node.val && q.val > node.val) {
      node = node.right;
    } else if (p.val < node.val && q.val < node.val) {
      node = node.left;
    } else if (p.val >= node.val && q.val <= node.val) {
      return node;
    } else if (p.val <= node.val && q.val >= node.val) {
      return node;
    }
  }
  // If we can't find the LCA, return null
  return null;
};
