package baekjoon.no12789_도키도키_간식드리미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        List<Integer> n = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Stack<Integer> stack = new Stack<>();

        String answer = "Nice";

        int i = 1;
        int j = 0;

        while (i < n.size()) {
            if (j < n.size()) {
                int num = n.get(j);
                if (num == i) {
                    i++;
                } else if (!stack.isEmpty() && i == stack.peek()) {
                    stack.pop();
                    i++;
                    j--;
                } else {
                    if (stack.isEmpty() || num < stack.peek()) {
                        stack.push(num);
                    } else {
                        answer = "Sad";
                        break;
                    }
                }
            } else {
                if (i != stack.pop()) {
                    answer = "Sad";
                    break;
                }
                i++;
            }
            j++;
        }

        System.out.println(answer);
    }
}
