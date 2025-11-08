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
    // repeat below process when given a node
    // calculate left subtree's height.
    // calculate right subtree's hegith.
    // calculate difference
    // check: the difference is greater than 1

    if (root === null) {
        return true;
    }
    // let depth = 0
    // getDepth(root, depth);
    // console.log(depth);
    // return isHeightBalanced(root);

    const unvisitedQueue = [root];

    console.log(unvisitedQueue.length);
    while(unvisitedQueue.length > 0) {
        const currentNode = unvisitedQueue.shift();
        console.log('currentNode', currentNode);
        if (currentNode === null) {
            continue;
        }
        if (!isHeightBalanced(currentNode)) {
            return false;
        };
        if (currentNode.left !== null) {
            unvisitedQueue.push(currentNode.left);
        }
        if (currentNode.right !== null) {
            unvisitedQueue.push(currentNode.right);
        }
    }
    return true;
};

function isHeightBalanced(node) {
    const rightDepthMax = dfs(node.right, 0);
    const leftDepthMax = dfs(node.left, 0);
    console.log('rightDepthMax', rightDepthMax);
    console.log('leftDepthMax', leftDepthMax);
    if (Math.abs(rightDepthMax - leftDepthMax) > 1) {
        return false;
    }
    return true;
}

function dfs(node, depth) {
    if (node === null) {
        return depth;
    }

    const leftDepth = dfs(node.left, depth+1);
    const rightDepth = dfs(node.right, depth+1); 
    return Math.max(leftDepth, rightDepth);
}
