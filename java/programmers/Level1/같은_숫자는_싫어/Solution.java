package programmers.Level1.같은_숫자는_싫어;

import java.util.Stack;

public class Solution {

    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.isEmpty() && arr[i] == stack.peek()) {
                continue;
            }
            stack.push(arr[i]);
        }
        int[] answer = new int[arr.length];
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
