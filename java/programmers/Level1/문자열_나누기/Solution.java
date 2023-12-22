package programmers.Level1.문자열_나누기;

public class Solution {
    public static int solution(String s) {
        int answer = 0;
        char x = '1';
        int count = 0;

        for (char c : s.toCharArray()) {
            if (x == '1') {
                x = c;
                count++;
                continue;
            } else if (x != c) {
                count--;
            } else {
                count++;
            }

            if (count == 0) {
                x = '1';
                answer++;
            }
        }

        if (count > 0) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int solution = Solution.solution("aaacccccxc");
        System.out.println("solution = " + solution);
    }
}
