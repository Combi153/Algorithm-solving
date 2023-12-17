package programmers.Level1.덧칠하기;

public class Solution {
    public static int solution(int n, int m, int[] section) {
        int cnt = 1;
        int start = section[0];

        for (int num : section) {
            if (num <= start + m - 1) {
                continue;
            }
            start = num;
            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int solution = Solution.solution(5, 4, new int[]{1, 3});
        System.out.println("solution = " + solution);
    }
}
