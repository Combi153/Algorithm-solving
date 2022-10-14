package get_middle;

public class Solution {
    public String solution(String s) {
        String answer = "";
        int start = (s.length() / 2);
        
        if (s.length() % 2 == 0){
            answer += s.substring(start - 1, start + 1);
        } else {
            answer += s.substring(start, start + 1);
        }
        
        return answer;
    }
}
