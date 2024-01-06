package programmers.Level2.연속된_부분_수열의_합;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};

        int p1 = 0;
        int p2 = 0;
        int sum = sequence[p1];

        while (true) {
            if (sum > k) {
                sum -= sequence[p1];
                p1++;
            } else if (sum == k) {
                if (p1 == sequence.length - 1 || p2 == 0) {
                    answer[0] = p1;
                    answer[1] = p2;
                    break;
                }
                if (answer[1] - answer[0] > p2 - p1) {
                    answer[0] = p1;
                    answer[1] = p2;
                }
                sum -= sequence[p1];
                p1++;
            } else {
                if (p2 < sequence.length - 1) {
                    p2++;
                    sum += sequence[p2];
                    continue;
                }
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.solution(new int[]{1, 2, 3, 4, 5}, 7);
        int[] result2 = solution.solution(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        int[] result3 = solution.solution(new int[]{2, 2, 2, 2, 2}, 6);
        int[] result4 = solution.solution(new int[]{2, 2, 2, 2, 2}, 2);
        System.out.println("result = " + Arrays.toString(result));
        System.out.println("result = " + Arrays.toString(result2));
        System.out.println("result = " + Arrays.toString(result3));
        System.out.println("result = " + Arrays.toString(result4));
    }
}
