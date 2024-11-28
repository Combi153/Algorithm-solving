package baekjoon.no2920_음계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());

        Set<Integer> gaps = new HashSet<>();
        for (int i = 0; i < numbers.size() - 1; i++) {
            int a = numbers.get(i);
            int b = numbers.get(i + 1);
            gaps.add(a - b);
        }
        if (gaps.size() > 1) {
            System.out.println("mixed");
            return;
        }
        int gap = new ArrayList<>(gaps).get(0);
        if (gap == -1) {
            System.out.println("ascending");
            return;
        }
        System.out.println("descending");
    }
}
