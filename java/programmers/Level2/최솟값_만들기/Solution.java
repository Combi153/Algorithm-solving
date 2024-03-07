package programmers.Level2.최솟값_만들기;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int lastIndex = A.length - 1;

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[lastIndex - i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
}
