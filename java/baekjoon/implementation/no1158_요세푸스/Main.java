package baekjoon.implementation.no1158_요세푸스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

    public void run() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<String> line = Arrays.stream(bufferedReader.readLine().split(" ")).collect(Collectors.toList());

        final int count = Integer.parseInt(line.get(0));
        final int order = Integer.parseInt(line.get(1));

        final Queue<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            numbers.offer(i);
        }

        final StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (numbers.size() != 1) {
            for (int i = 0; i < order - 1; i++) {
                numbers.offer(numbers.poll());
            }
            sb.append(numbers.poll()).append(", ");
        }
        sb.append(numbers.poll()).append(">");
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        final Main main = new Main();
        main.run();
    }
}
