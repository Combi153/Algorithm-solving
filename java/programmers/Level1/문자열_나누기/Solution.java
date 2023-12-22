package programmers.Level1.문자열_나누기;

public class Solution {
    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);

            int xcnt = 1;
            int ycnt = 0;

            if (i == s.length() - 1) {
                answer++;
                break;
            }

            for (int j = i + 1; j < s.length(); j++) {
                char b = s.charAt(j);

                i = j;
                if (a == b) {
                    xcnt++;
                } else {
                    ycnt++;
                }

                if (j == s.length() - 1 || xcnt == ycnt) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = Solution.solution("abccxc");
        System.out.println("solution = " + solution);
    }
}
