package programmers.Level1.개인정보_수집_유효기간;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> day = Arrays.stream(today.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());

        Map<String, Integer> termMap = new HashMap<>();
        for (String m : terms) {
            String[] s = m.split(" ");
            termMap.put(s[0], Integer.valueOf(s[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String x = privacies[i];
            String[] ss = x.split(" ");

            List<Integer> xday = Arrays.stream(ss[0].split("\\.")).map(Integer::valueOf)
                    .collect(Collectors.toList());
            String xterm = ss[1];

            int m = termMap.get(xterm) + xday.get(1);

            int toD;
            int toM;
            int toY;

            if (xday.get(2) == 1) {
                toD = 28;
                m -= 1;
            } else {
                toD = xday.get(2) - 1;
            }
            toM = m % 12;
            if (toM == 0) {
                toM = 12;
                toY = xday.get(0) + (m / 12) - 1;
            } else {
                toY = xday.get(0) + (m / 12);
            }

            if (toY < day.get(0) ||
                    toY == day.get(0) && toM < day.get(1) ||
                    toY == day.get(0) && toM == day.get(1) && toD < day.get(2)) {
                answer.add(i + 1);
            }
            System.out.println(i + 1 + ":" + toY + "." + toM + "." + toD);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] solution = Solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.09.20 C"});
        System.out.println(Arrays.toString(solution));
    }
}
