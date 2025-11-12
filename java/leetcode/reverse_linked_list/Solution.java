package leetcode.reverse_linked_list;

import java.util.Stack;


public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2));
        Solution solution = new Solution();
        solution.reverseList(head);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pointerNode = head;
        Stack<ListNode> stack = new Stack<>();

        while (pointerNode != null) {
            stack.add(pointerNode);
            pointerNode = pointerNode.next;
        }

        ListNode dummyHead = new ListNode();
        ListNode pointerNode2 = dummyHead;

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            pointerNode2.next = new ListNode(node.val, null);
            pointerNode2 = pointerNode2.next;
        }
        return dummyHead.next;
    }
}
