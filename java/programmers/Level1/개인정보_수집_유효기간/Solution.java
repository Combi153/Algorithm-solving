package programmers.Level1.개인정보_수집_유효기간;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int todayDays = getDays(today);
        System.out.println("todayDays = " + todayDays);

        Map<String, Integer> termMap = new HashMap<>();
        for (String m : terms) {
            String[] s = m.split(" ");
            termMap.put(s[0], Integer.valueOf(s[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String x = privacies[i];
            String[] ss = x.split(" ");

            int xdays = getDays(ss[0]) - 1;
            xdays += termMap.get(ss[1]) * 28;

            if (todayDays > xdays) {
                answer.add(i + 1);
            }
            System.out.println(i + 1 + " : " + xdays);
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int getDays(String date) {
        String[] split = date.split("\\.");

        int days = Integer.parseInt(split[0]) * 12 * 28;
        days += Integer.parseInt(split[1]) * 28;
        days += Integer.parseInt(split[2]);
        return days;
    }

    public static void main(String[] args) {
        int[] solution = Solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.09.20 C"});
        System.out.println(Arrays.toString(solution));
    }
}
