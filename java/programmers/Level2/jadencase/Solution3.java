package jadencase;

//Cap 65 ~ 90 / 97 ~ 122 / 32

public class Solution3 {
	public String solution(String s) {
		String answer = "";
		String[] words = s.split(" ");
		
		for (int i = 0; i < words.length; i++) {
		
			try {
				words[i].charAt(0);
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
				answer += word + " ";
			} catch (Exception e) {
				continue;
			}
		}

		return answer.trim();
	}


	public static void main(String[] args) {
		String input = "3BBBBBBBBCCCCaaaCCCBBBzzzZZZZ  ZZzzzz   9aAaaAA 0asdf 1AQWFE 2ASFDWQF 9ASDFADSFd";
		Solution3 check = new Solution3();
		System.out.println(check.solution(input));
	}
}
 