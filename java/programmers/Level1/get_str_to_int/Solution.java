package get_str_to_int;

public class Solution {
    public int solution(String s) {
        int answer = 0;
        char sign = s.charAt(0);
        String[] numbers = s.split("");
        
        if (sign == '-') {
            numbers[0] = "0";
            
            for (int i = 0; i < s.length(); i++){
                int temp = Integer.parseInt(numbers[i]);
                answer += temp * ((int) (Math.pow(10,s.length() - i - 1)));
            }
            answer *= -1;
        } else if (sign == '+') {
            numbers[0] = "0";
            for (int i = 0; i < s.length(); i++){
                int temp = Integer.parseInt(numbers[i]);
                answer += temp * ((int) (Math.pow(10,s.length() - i - 1)));
            }
        } else {
            for (int i = 0; i < s.length(); i++) {
                int temp = Integer.parseInt(numbers[i]);
                answer += temp * ((int) (Math.pow(10,s.length() - i - 1)));
            }
        }
        return answer;
    }
}