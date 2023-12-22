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

            Stack<Integer> fstack = new Stack<>();
            Stack<Integer> sstack = new Stack<>();
            Stack<Integer> bstack = new Stack<>();

            for (char c : l.toCharArray()) {
                if (c == '(') {
                    sstack.push(1);
                    fstack.push(1);
                    continue;
                }
                if (c == '[') {
                    bstack.push(2);
                    fstack.push(2);
                    continue;
                }
                if (c == ')') {
                    if (sstack.isEmpty() || fstack.isEmpty() || fstack.pop() == 2) {
                        sstack.push(1);
                        break;
                    }
                    sstack.pop();
                    continue;
                }
                if (c == ']') {
                    if (bstack.isEmpty() || fstack.isEmpty() || fstack.pop() == 1) {
                        bstack.push(2);
                        break;
                    }
                    bstack.pop();
                }
            }

            if (sstack.isEmpty() && bstack.isEmpty()) {
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
