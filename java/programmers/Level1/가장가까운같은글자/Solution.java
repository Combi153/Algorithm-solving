package programmers.Level1.가장가까운같은글자;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<String, Integer> map = new HashMap<>();

        String[] ss = s.split("");

        for (int i = 0; i < ss.length; i++) {
            String x = ss[i];
            if (map.containsKey(x)) {
                int y = map.get(x);
                map.put(x, i);
                answer[i] = i - y;
                continue;
            }
            map.put(x, i);
            answer[i] = -1;
        }

        return answer;
    }
}
