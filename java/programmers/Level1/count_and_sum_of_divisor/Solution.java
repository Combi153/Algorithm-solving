package count_and_sum_of_divisor;

public class Solution {

    public int solution(int left, int right) {
        int answer = 0;
        int count;
        
        for (int i = left; i < right + 1; i++) {
        	count = 0;
            for (int j = 1; j <= i; j++) {
            	count += (i % j == 0)? 1 : 0;
            }
            System.out.println(i + ", " + count);
            answer += (count % 2 == 0) ? i : -i ;
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		Solution check = new Solution();
		System.out.println(check.solution(24, 27));
		
	}

}
