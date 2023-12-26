package programmers.Level1.명예의전당1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> gs = new ArrayList<>();
        int[] ps = new int[score.length];

        if (k > score.length) {
            for (int i = 0; i < score.length; i++) {
                gs.add(score[i]);
                ps[i] = gs.stream().min(Integer::compareTo).get();
            }
            return ps;
        }

        for (int i = 0; i < k; i++) {
            gs.add(score[i]);
            ps[i] = gs.stream().min(Integer::compareTo).get();
        }

        for (int i = k; i < score.length; i++) {
            int min = gs.stream().min(Integer::compareTo).get();
            int sc = score[i];

            if (min < sc) {
                gs.remove((Integer) min);
                gs.add(sc);
                min = gs.stream().min(Integer::compareTo).get();
            }

            ps[i] = min;
        }

        return ps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(78, new int[]{0, 0, 0, 0, 0, 0, 0});
        System.out.println("result = " + Arrays.toString(result));
    }
}
