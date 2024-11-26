package baekjoon.no10798_세로읽기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 5;
        List<List<String>> words = new ArrayList<>();
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            List<String> word = Arrays.stream(br.readLine().split("")).collect(Collectors.toList());
            words.add(word);
            if (word.size() > maxCount) {
                maxCount = word.size();
            }
        }

        for (int i = 0; i < maxCount; i++) {
            for (int j = 0; j < words.size(); j++) {
                List<String> word = words.get(j);
                if (word.size() <= i) {
                    continue;
                }
                System.out.print(word.get(i));
            }
        }
    }
}
