package count_p_y;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        String[] sArray = s.split("");
        
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i].equals("p") || sArray[i].equals("P")) {
                pCnt++;
            } else if (sArray[i].equals("y") || sArray[i].equals("Y")) {
                yCnt++;
            } 
        }
       
        if (pCnt != yCnt) {
            answer = false;
        }
        return answer;
    }
}
