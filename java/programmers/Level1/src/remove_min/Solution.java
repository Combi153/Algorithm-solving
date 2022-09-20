package remove_min;

public class Solution {
    public int[] solution(int[] arr) {
        
        if (arr.length > 1) {
            int[] answer = new int[arr.length - 1];
            int idx = 0;
            int minNum = arr[idx];
            
            for (int i = 1; i < arr.length; i++) {
                if (minNum > arr[i]) {
                    minNum = arr[i];
                }
            }
            
            for (int i = 0; i < arr.length; i++) {
               if (arr[i] != minNum) {
                   answer[idx] = arr[i];
                   idx++;
               }
            }
            return answer;
            
        } else {
            int[] answer = new int[] {-1};
            return answer;
        }
    }
}
