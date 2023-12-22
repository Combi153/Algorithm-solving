package baekjoon.no4949_균형잡힌_세상;

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

        while (true) {
            String l = br.readLine();
            if (l.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();

            for (char c : l.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                    continue;
                }

                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                    continue;
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                bw.write("yes" + System.lineSeparator());
            } else {
                bw.write("no" + System.lineSeparator());
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
