package baekjoon.no0912_괄호;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < cnt; i++) {
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push("");
                } else if (stack.isEmpty()) {
                    stack.push("");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                bw.write("YES" + System.lineSeparator());
            } else {
                bw.write("NO" + System.lineSeparator());
            }
            stack.clear();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
