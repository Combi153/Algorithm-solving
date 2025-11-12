package leetcode.ransom_note;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < magazine.length(); i++) {
            String character = String.valueOf(magazine.charAt(i));
            if (ransomNote.contains(character)) {
                ransomNote = ransomNote.replaceFirst(character, "");
            }
            if (ransomNote.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
