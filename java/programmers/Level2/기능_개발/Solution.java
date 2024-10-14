package programmers.Level2.기능_개발;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int firstOrder = 0;
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new int[]{progresses[i], speeds[i], i});
        }

        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int progress = item[0];
            int speed = item[1];
            int order = item[2];
            int nextProgress = progress + speed;

            if (progress >= 100 && firstOrder == order) {
                int count = 1;
                firstOrder++;
                while (!queue.isEmpty()) {
                    if (queue.peek()[0] >= 100) {
                        queue.poll();
                        count++;
                        firstOrder++;
                        continue;
                    }
                    break;
                }
                counts.add(count);
                continue;
            }
            queue.add(new int[]{nextProgress, speed, order});
        }

        return counts.stream().mapToInt(Integer::intValue).toArray();
    }
}
