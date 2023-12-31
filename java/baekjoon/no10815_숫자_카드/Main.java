package baekjoon.no10815_숫자_카드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> nCards = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int m = Integer.parseInt(br.readLine());
        List<Integer> mCards = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 0; i < m; i++) {
            sj.add(check(nCards, 0, nCards.size() - 1, mCards.get(i)));
        }
        System.out.println(sj);
    }

    private static String check(List<Integer> nCards, int left, int right, int x) {
        if (left > right) {
            return "0";
        }

        int mid = (left + right) / 2;

        if (x < nCards.get(mid)) {
            return check(nCards, left, mid - 1, x);
        } else if (x > nCards.get(mid)) {
            return check(nCards, mid + 1, right, x);
        } else {
            return "1";
        }
    }
}
