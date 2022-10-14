package descending_string;

public class Solution {
    public String solution(String s) {
        String answer = "";
        char highest;
        int lengthOfS = s.length();
        
        while (true) {
            highest = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (highest < s.charAt(i)) {
                    highest = s.charAt(i);
                }
            }
            s = s.replaceFirst(String.valueOf(highest),"");    
            answer += String.valueOf(highest);

            if (answer.length() == lengthOfS){
                break;
            }
        }    
        return answer;
    }
}