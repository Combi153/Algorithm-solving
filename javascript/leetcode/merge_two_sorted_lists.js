/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function (list1, list2) {
    let dummyNode = new ListNode(-1);
    let temp = dummyNode;

    let cur1 = list1;
    let cur2 = list2;

    while (cur1 !== null && cur2 !== null) {
        if (cur1.val < cur2.val) {
            temp.next = cur1;
            cur1 = cur1.next;
        } else {
            temp.next = cur2;
            cur2 = cur2.next;
        }
        temp = temp.next;
    }
    temp.next = cur1 !== null ? cur1 : cur2;
    return dummyNode.next;
};