package programmers.Level1.기사단원의_무기;

public class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int count = countDivisor(i);

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
        }

        return answer;
    }

    private int countDivisor(int number) {
        int count = 0;
        double sqrtN = Math.sqrt(number);
        for (int i = 1; i <= sqrtN; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution : " + s.solution(10, 3, 2));
    }
}
