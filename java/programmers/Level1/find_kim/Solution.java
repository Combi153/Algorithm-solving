package find_kim;

public class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        
        for (int i = 0; i < seoul.length; i++){
            if (seoul[i].equals("Kim")) {
                String location = String.valueOf(i);
                answer = "김서방은 " + location + "에 있다";
                break;    
            }
        }
        
        
        return answer;
    }
}