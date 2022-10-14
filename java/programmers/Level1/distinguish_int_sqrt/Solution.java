package distinguish_int_sqrt;

public class Solution {
	public long solution(long n) {
        long answer = -1;
        double sqrtDouble = Math.sqrt(n);
        
        if (sqrtDouble == (int)sqrtDouble) {
            answer = (long) Math.pow((sqrtDouble + 1), 2);
        }
        return answer;
    }
}
