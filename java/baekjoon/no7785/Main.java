package baekjoon.no7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Boolean> log = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            Boolean isEntered = Objects.equals(st.nextToken(), "enter");

            if (log.containsKey(name) && log.get(name) == isEntered) {
                continue;
            }
            log.put(name, isEntered);
        }

        log.keySet().stream()
                .filter(log::get)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        br.close();
    }
}
