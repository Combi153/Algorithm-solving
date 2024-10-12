package baekjoon.no10828_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");

            String command = commands[0];

            if (command.equals("push")) {
                int num = Integer.parseInt(commands[1]);
                stack.push(num);
            }
            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
            }
            if (command.equals("size")) {
                System.out.println(stack.size());
            }
            if (command.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
            }
            if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
            }
        }
    }
}
