package programmers.Level1.이상한_문자_만들기;

public class Solution {
    public String solution(String s) {
        String[] x = s.split("");
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (int j = 0; j < x.length; j++) {
            if (x[j].equals(" ")) {
                i = 0;
                sb.append(" ");
                continue;
            }
            if (i % 2 == 0) {
                sb.append(x[j].toUpperCase());
                i++;
                continue;
            }
            sb.append(x[j].toLowerCase());
            i++;
        }

        return sb.toString();
    }
}
