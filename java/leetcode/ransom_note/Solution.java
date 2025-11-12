package leetcode.ransom_note;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            magazineMap.put(letter, magazineMap.getOrDefault(letter, 0) + 1);
        }

        for (char letter : ransomNote.toCharArray()) {
            Integer count2 = magazineMap.get(letter);
            if (count2 == null || count2 == 0) {
                return false;
            }
            magazineMap.put(letter, count2 - 1);
        }
        return true;
    }
}
