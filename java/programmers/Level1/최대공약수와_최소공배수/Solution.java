package programmers.Level1.최대공약수와_최소공배수;

public class Solution {
    public static int[] solution(int n, int m) {
        int i = Math.min(n, m);
        while (true) {
            if ((n % i == 0) && (m % i == 0)) {
                break;
            }
            i--;
        }

        int max = Math.max(n, m);
        int j = max;
        int k = 1;
        while (true) {
            if ((j % n == 0) && (j % m == 0)) {
                break;
            }
            k++;
            j = max * k;
        }

        return new int[]{i, j};
    }

    public static void main(String[] args) {
        int[] solution = Solution.solution(11, 17);
        System.out.println("solution[0] = " + solution[0]);
        System.out.println("solution[1] = " + solution[1]);
    }
}
