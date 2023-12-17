package programmers.Level1.대충만든자판;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                String x = String.valueOf(s.charAt(i));
                if (map.containsKey(x)) {
                    map.put(x, Math.min(i + 1, map.get(x)));
                    continue;
                }
                map.put(x, i + 1);
            }
        }

        int[] answer = new int[targets.length];
        for (int j = 0; j < targets.length; j++) {
            String s = targets[j];
            answer[j] = 0;
            for (int i = 0; i < s.length(); i++) {
                String x = String.valueOf(s.charAt(i));
                if (map.containsKey(x)) {
                    answer[j] += map.get(x);
                    continue;
                }
                answer[j] = -1;
                break;
            }
        }

        return answer;
    }
}
