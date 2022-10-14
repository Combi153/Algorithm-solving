package min_and_max;

public class Solution {
    public String solution(String s) {
        String answer;
        String[] strArray = s.split(" ");
        int[] numArray = new int[strArray.length];
        
        
        for (int i = 0; i < strArray.length; i++) {
            numArray[i] = Integer.parseInt(strArray[i]);
        }
        
        int min = numArray[0];
        int max = numArray[0];
        
        for (int i = 1; i < numArray.length ; i++) {
            if (max < numArray[i]){
                max = numArray[i];
            }
            if (min > numArray[i]){
                min = numArray[i]; 
            }
        }
        
        answer = min + " " + max;
        return answer;
    }
}
