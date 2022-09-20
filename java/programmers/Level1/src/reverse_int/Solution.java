package reverse_int;

import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        long answer = 0;
        String number = n + "";
        String result = "";
        String[] strNumbers = number.split("");
        
        Arrays.sort(strNumbers);
        
        for (int i = 0; i < strNumbers.length / 2; i++) {
            String temp = strNumbers[i];
            strNumbers[i] = strNumbers[strNumbers.length - (i + 1)];
            strNumbers[strNumbers.length - (i + 1)] = temp;
        }
        
        for (int i = 0; i < strNumbers.length; i++) {
            result += strNumbers[i];
        }
        
        answer = Long.parseLong(result);
        
        return answer;
    }
}