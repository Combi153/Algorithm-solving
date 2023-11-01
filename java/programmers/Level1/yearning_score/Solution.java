package programmers.Level1.yearning_score;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        Arrays.stream(solution(name, yearning, photo)).forEach(System.out::println);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        int score;
        for (int i = 0; i < photo.length; i++) {
            int count;
            score = 0;
            for (int j = 0; j < name.length; j++) {
                List<String> x = Arrays.asList(photo[i]);
                count = 0;
                for (int k = 0; k < x.size(); k++) {
                    if (x.get(k).equals(name[j])) {
                        count++;
                    }
                }
                score += count * yearning[j];
            }
            answer[i] = score;
        }

        return answer;
    }
}
