package programmers.Level1.크기가_작은_부분문자열;

public class Solution {
    public int solution(String t, String p) {
        Long pn = Long.parseLong(p);
        int pl = p.length();
        int x = t.length() - pl + 1;
        int cnt = 0;

        for (int i = 0; i < x; i++) {
            String y = t.substring(i, i + pl);
            if (Long.parseLong(y) <= pn) {
                cnt++;
            }
        }

        return cnt;
    }
}
