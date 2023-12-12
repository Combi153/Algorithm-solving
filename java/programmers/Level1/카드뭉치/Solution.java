package programmers.Level1.카드뭉치;

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        int k = cards1.length;
        int m = cards2.length;
        String answer = "Yes";

        for (int l = 0; l < goal.length; l++) {
            String g = goal[l];

            if (i < k && g.equals(cards1[i])) {
                i++;
                continue;
            }

            if (j < m && g.equals(cards2[j])) {
                j++;
                continue;
            }

            answer = "No";
            break;
        }

        return answer;
    }
}
