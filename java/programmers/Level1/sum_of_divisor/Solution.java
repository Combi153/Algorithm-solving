package sum_of_divisor;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        
        while (num <= n) {
            if (n % num == 0){
                answer += num;
            }
            num++;
        }
        
        return answer;
    }
}
