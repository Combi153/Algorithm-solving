package programmers.Level2.전화번호_목록;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        Map<String, Integer> prefixByCount = new HashMap<>();
        prefixByCount.put(phone_book[0], 1);

        for (int i = 1; i < phone_book.length; i++) {
            String number = phone_book[i];

            for (int j = 0; j < number.length(); j++) {
                String prefix = number.substring(0, j + 1);

                if (prefixByCount.containsKey(prefix)) {
                    prefixByCount.put(prefix, prefixByCount.get(prefix) + 1);
                }
            }
            prefixByCount.put(number, 1);
        }

        for (int value : prefixByCount.values()) {
            if (value > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"12", "1"}));
    }
}
