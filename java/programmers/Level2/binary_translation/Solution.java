package binary_translation;

import java.util.Arrays;

public class Solution {
	public int[] solution(String s) {
		int[] answer = new int[2];
		String zero = "";
		String number = s;
		answer[0] = 0;

		while (!number.equals("1")) {
			String[] sArray = number.split("");
			number = "";
			answer[0] += 1;

			for (int i = 0; i < sArray.length; i++) {
				if (sArray[i].equals("1")) {
					number += sArray[i];
				} else {
					zero += sArray[i];
				}
			}
			number = Integer.toBinaryString(number.length());
		}
		answer[1] = zero.length();
		return answer;
	}

	public static void main(String[] args) {

		Solution check = new Solution();
		String answerCheck = Arrays.toString(check.solution("01110"));
		System.out.println(answerCheck);
	}

}
