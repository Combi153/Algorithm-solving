package jadencase;

import java.util.Arrays;

//Cap 65 ~ 90 / 97 ~ 122 / 32
//공백이 여러 개인걸 반영해야 하나?

public class Solution4 {
	public String solution(String s) {
		String answer = "";
		String[] words = s.split(" ");
		System.out.println(Arrays.toString(words));

		for (int i = 0; i < words.length; i++) {

			char[] alphabet = words[i].toCharArray();
			String word = "";

			for (int j = 0; j < alphabet.length; j++) {
				if (j < 1) {
					if (alphabet[j] >= 97 && alphabet[j] <= 122) {
						alphabet[j] -= 32;
						word += alphabet[j];
					} else {
						word += alphabet[j];
					}

				} else {
					if (alphabet[j] >= 65 && alphabet[j] <= 90) {
						alphabet[j] += 32;
						word += alphabet[j];
					} else {
						word += alphabet[j];
					}
				}
			}
			if (i < words.length - 1) {
				answer += word + " ";
			} else {
				answer += word;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String input = "3BBBBBBBBCCCCaaaCCCBBBzzzZZZZ  ZZzzzz   9aAaaAA 0asdf 1AQWFE 2ASFDWQF 9ASDFADSFd   ";
		// "BaaaBaaaAbbabab AAbbbbbAABababBBBabab 3AAAAAAA aABaba"
		Solution4 check = new Solution4();
		System.out.println(check.solution(input));
	}
}
