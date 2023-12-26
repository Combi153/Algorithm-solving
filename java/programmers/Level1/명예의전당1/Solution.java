package programmers.Level1.명예의전당1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            int s = score[i];
            if (pq.size() < k) {
                pq.add(s);
                answer[i] = pq.peek();
                continue;
            }

            if (pq.peek() < s) {
                pq.add(s);
                pq.remove();
                answer[i] = pq.peek();
            } else {
                answer[i] = pq.peek();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200});
        System.out.println("result = " + Arrays.toString(result));
    }
}
