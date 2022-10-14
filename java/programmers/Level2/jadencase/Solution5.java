package jadencase;

import java.util.Arrays;

//다른 사람 풀이 예술이네;;;

public class Solution5 {
  public String solution(String s) {
        String answer = "";
        String[] sp = s.toLowerCase().split("");
        System.out.println(Arrays.toString(sp));
        boolean flag = true;

        for(String ss : sp) {
            answer += flag ? ss.toUpperCase() : ss;
            flag = ss.equals(" ") ? true : false;
        }

        return answer;
  }


	public static void main(String[] args) {
		String input = "3BBBBBBBBCCCCaaaCCCBBBzzzZZZZ  zZzzzz   aAaaAA 0asdf 1AQWFE 2ASFDWQF 9ASDFADSFd   ";
		// "BaaaBaaaAbbabab AAbbbbbAABababBBBabab 3AAAAAAA aABaba"
		Solution5 check = new Solution5();
		System.out.println(check.solution(input));
	}
}
