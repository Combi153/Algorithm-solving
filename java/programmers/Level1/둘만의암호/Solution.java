package programmers.Level1.둘만의암호;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String solution(String s, String skip, int index) {
        List<String> chars = new ArrayList<>();
        Map<String, Integer> charMap = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            String x = String.valueOf((char) (i + 97));
            if (skip.contains(x)) {
                continue;
            }
            chars.add(x);
            charMap.put(x, chars.size() - 1);
        }

        String[] ss = s.split("");

        for (int i = 0; i < ss.length; i++) {
            String ch = ss[i];
            int idx = charMap.get(ch);
            int update = idx + index;
            while (update >= charMap.size()) {
                update -= charMap.size();
            }
            ss[i] = chars.get(update);
        }

        return String.join("", ss);
    }
}
