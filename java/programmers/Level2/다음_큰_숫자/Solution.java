package programmers.Level2.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        String x = Integer.toBinaryString(n);
        int x_count = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '1') {
                x_count++;
            }
        }

        while (true) {
            n = n + 1;
            String y = Integer.toBinaryString(n);
            int y_count = 0;
            for (int i = 0; i < y.length(); i++) {
                if (y.charAt(i) == '1') {
                    y_count++;
                }
            }

            if (x_count == y_count) {
                break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.solution(78) = " + solution.solution(78));
        System.out.println("solution.solution(15) = " + solution.solution(15));
    }
}
