package baekjoon.implementation.no1158_요세푸스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public void run() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<String> line = Arrays.stream(bufferedReader.readLine().split(" ")).collect(Collectors.toList());

        final int count = Integer.parseInt(line.get(0));
        final int order = Integer.parseInt(line.get(1));

        final List<Integer> integers = new LinkedList<>();
        for (int i = 1; i <= count; i++) {
            integers.add(i);
        }

        final List<String> results = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < count; i++) {
            int endInclusive = integers.size() - 1;
            for (int j = 1; j < order; j++) {
                if (index == endInclusive || endInclusive == 0) {
                    index = 0;
                } else if (index > endInclusive) {
                    index = 1;
                } else {
                    index++;
                }
            }
            results.add(String.valueOf(integers.get(index)));
            integers.remove(index);
        }
        System.out.println(results.stream().collect(Collectors.joining(", ", "<", ">")));
    }

    public static void main(String[] args) throws IOException {
        final Main main = new Main();
        main.run();
    }
}
