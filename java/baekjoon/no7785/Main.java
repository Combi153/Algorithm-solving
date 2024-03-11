package baekjoon.no7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> nameLog = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            boolean isEntered = Objects.equals(st.nextToken(), "enter");

            if (nameLog.contains(name) && !isEntered) {
                nameLog.remove(name);
                continue;
            }

            if (isEntered) {
                nameLog.add(name);
            }
        }

        nameLog.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        br.close();
    }
}
