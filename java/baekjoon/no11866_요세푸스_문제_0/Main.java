package baekjoon.no11866_요세푸스_문제_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> answer = new ArrayList<>();

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            i++;
            if (i == k) {
                answer.add(queue.poll());
                i -= k;
            } else {
                queue.add(queue.poll());
            }
        }

        System.out.println(answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "<", ">")));
    }
}
