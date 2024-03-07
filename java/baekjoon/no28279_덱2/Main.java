package baekjoon.no28279_덱2;

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
            String[] command = br.readLine().split(" ");

            if (command[0].equals("1")) {
                deque.addFirst(command[1]);
            } else if (command[0].equals("2")) {
                deque.addLast(command[1]);
            } else if (command[0].equals("3")) {
                if (deque.isEmpty()) {
                    bw.write("-1" + System.lineSeparator());
                } else {
                    bw.write(deque.pollFirst() + System.lineSeparator());
                }
            } else if (command[0].equals("4")) {
                if (deque.isEmpty()) {
                    bw.write("-1" + System.lineSeparator());
                } else {
                    bw.write(deque.pollLast() + System.lineSeparator());
                }
            } else if (command[0].equals("5")) {
                bw.write(deque.size() + System.lineSeparator());
            } else if (command[0].equals("6")) {
                if (deque.isEmpty()) {
                    bw.write("1" + System.lineSeparator());
                } else {
                    bw.write("0" + System.lineSeparator());
                }
            } else if (command[0].equals("7")) {
                if (deque.isEmpty()) {
                    bw.write("-1" + System.lineSeparator());
                } else {
                    bw.write(deque.peek() + System.lineSeparator());
                }
            } else if (command[0].equals("8")) {
                if (deque.isEmpty()) {
                    bw.write("-1" + System.lineSeparator());
                } else {
                    bw.write(deque.peekLast() + System.lineSeparator());
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
