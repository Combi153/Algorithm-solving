package leetcode.reverse_linked_list;

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
        ListNode past = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;

            current.next = past;
            past = current;
            current = next;
        }
        return past;
    }
}
