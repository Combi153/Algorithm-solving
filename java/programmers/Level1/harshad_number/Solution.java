package harshad_number;

public class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String strX = x + "";
        int divider = 0;
        
        for (int i = 0; i < strX.length(); i++) {
            int num = strX.charAt(i) - '0';
            divider += num;
        }
        
        if (x % divider != 0) {
            answer = false;
        }
        return answer;
    }
}
