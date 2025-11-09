/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    const visited = new Map();
    let node = head;

    while(node !== null) {
        console.log('node.val', node.val);
        if (visited.get(node) !== undefined) {
            return true;
        }
        visited.set(node, 1);
        node = node.next;
    }
    return false;
};

// let node = head;
// let count = 0;
// const maxLength = 10 * 10 * 10 * 10;

// while(node !== null) {
//     // console.log('node.val', node.val);
//     // if (visited.get(node.val) !== undefined) {
//     //     return true;
//     // }
//     // visited.set(node.val, 1);
//     node = node.next;
//     count++;
//     if (count > maxLength) {
//         return true;
//     }
// }
// return false;