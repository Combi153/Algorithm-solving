package make_reverse_num_array;

public class Solution {
    public long[] solution(long n) {
        int lengthOfNum = (int) (Math.log10(n) + 1);
        long[] answer = new long[lengthOfNum];
        
        for (int i = 0; i < answer.length; i++){
            long result = n % (long) (Math.pow(10, (i + 1)));
            answer[i] = (result - (n % (long) (Math.pow(10, i)))) / (long) (Math.pow(10, i)) ;
            System.out.println(answer[i]);
        }
        return answer;
    }
}

// 다른 사람 코드

class OthersSolution{
	public int[] solution(long n) {
		String a = "" + n;
		int[] answer = new int[a.length()];
		int cnt = 0;
		
		while (n > 0) {
			answer[cnt] =(int)(n % 10);
			n /= 10;
			cnt++;
		}
		return answer;
	}
}