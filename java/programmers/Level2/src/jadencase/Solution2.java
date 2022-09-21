package jadencase;

import java.util.Arrays;

public class Solution2 {
	public String solution(String s) {
		String answer = "";
		// Cap 65 ~ 90 / 97 ~ 122 / 32
		// System.out.println(s.replace(" ",""));
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (j < 1) {
					System.out.println((int) words[i].charAt(j));
					if (words[i].charAt(j) >= 97 && words[i].charAt(j) <= 122) {
						char firstChar = (char) (words[i].charAt(j) - 32);

						// System.out.println(words[i].charAt(j));
						System.out.println(firstChar);

						words[i] = String.valueOf(firstChar) + words[i].substring(j + 1);
						// System.out.println(words[i]);

					} else {
						continue;
					}
				} else {
					if (words[i].charAt(j) >= 65 && words[i].charAt(j) <= 90) {
						char lowerChar = (char) (words[i].charAt(j) + 32);
						words[i] = words[i].replaceFirst(String.valueOf(words[i].charAt(j)), String.valueOf(lowerChar));
					} // 문제지점 여기임!
				}
				// System.out.println(words[i].charAt(j));
			}
			// System.out.println(words[i]);
		}

		for (int i = 0; i < words.length; i++) {
			try {
				words[i].charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				continue;
			}

			answer += words[i];
			if (i != words.length - 1) {
				answer += " ";
			}
		}
		System.out.println(Arrays.toString(words));
		System.out.println(answer);
		return answer;
	}


	public static void main(String[] args) {
		String input = "JjjJjjJuchanmin";
		Solution2 check = new Solution2();
		System.out.println(check.solution(input));
	}
}
