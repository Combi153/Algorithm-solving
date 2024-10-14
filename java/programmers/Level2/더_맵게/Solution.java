package 더_맵게;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> scovilles = new PriorityQueue<>();
        for (int foodScoville : scoville) {
            scovilles.add(foodScoville);
        }

        int i = 0;
        while (scovilles.size() > 1 && scovilles.peek() < K) {
            int minScoville = scovilles.poll();
            int nextMinScovill = scovilles.poll();
            int mixedScoville = minScoville + (nextMinScovill * 2);
            scovilles.add(mixedScoville);
            i++;
        }
        if (scovilles.peek() < K) {
            return -1;
        }
        return i;
    }
}
