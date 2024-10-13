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
        while (true) {
            int minScoville = scovilles.poll();
            if (scovilles.isEmpty() && minScoville < K) {
                i = -1;
                break;
            }
            if (minScoville >= K) {
                break;
            }
            int nextMinScovill = scovilles.poll();
            if (nextMinScovill == 0) {
                i = -1;
                break;
            }
            int mixedScoville = minScoville + (nextMinScovill * 2);
            scovilles.add(mixedScoville);
            i++;
        }
        return i;
    }
}
