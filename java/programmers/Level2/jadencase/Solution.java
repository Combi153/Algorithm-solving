package jadencase;


//Cap 65 ~ 90 / 97 ~ 122 / 32
//공백이 여러 개인걸 반영해야 하나?

public class Solution {
	public String solution(String s) {
		String answer = "";
		char[] words = s.toCharArray();

		if (words[0] >= 97 && words[0] <= 122) {
			words[0] -= 32;
		}		
		
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i] == 32 && words[i + 1] >= 97 && words[i + 1] <= 122) {
				words[i + 1] -= 32;
				answer += words[i];
			} else if (words[i] != 32 && words[i + 1] >= 65 && words[i + 1] <= 90) {
				words[i + 1] += 32;
				answer += words[i];
			} else {
				answer += words[i];
			}
		}
		answer += words[words.length - 1];
		return answer;
	}

	public static void main(String[] args) {
		String input = "3BBBBBBBBCCCCaaaCCCBBBzzzZZZZ  zZzzzz   aAaaAA 0asdf 1AQWFE 2ASFDWQF 9ASDFADSFd   ";
		Solution check = new Solution();
		System.out.println(check.solution(input));
	}
}
