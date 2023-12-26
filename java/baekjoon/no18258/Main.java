package baekjoon.no18258;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < cnt; i++) {
            String[] s = br.readLine().split(" ");
            String com = s[0];
            if (com.equals("push")) {
                deque.add(s[1]);
            } else if (com.equals("front")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + System.lineSeparator());
                } else {
                    bw.write(deque.peek() + System.lineSeparator());
                }
            } else if (com.equals("back")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + System.lineSeparator());
                } else {
                    bw.write(deque.peekLast() + System.lineSeparator());
                }
            } else if (com.equals("size")) {
                bw.write(deque.size() + System.lineSeparator());
            } else if (com.equals("empty")) {
                if (deque.isEmpty()) {
                    bw.write(1 + System.lineSeparator());
                } else {
                    bw.write(0 + System.lineSeparator());
                }
            } else if (com.equals("pop")) {
                if (deque.isEmpty()) {
                    bw.write(-1 + System.lineSeparator());
                } else {
                    bw.write(deque.poll() + System.lineSeparator());
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
