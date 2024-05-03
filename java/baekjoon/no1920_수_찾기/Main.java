package baekjoon.no1920_수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> aNums = new ArrayList<>();

    static int contains(int number, int start, int end) {
        if (end - start == 1) {
            if (aNums.get(end) != number && aNums.get(start) != number) {
                return 0;
            } else {
                return 1;
            }
        }

        int midIdx = (end + start) / 2;
        int mid = aNums.get(midIdx);

        if (mid == number) {
            return 1;
        }

        if (mid > number) {
            return contains(number, start, midIdx);
        }
        return contains(number, midIdx, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            aNums.add(Integer.parseInt(st.nextToken()));
        }
        aNums.sort(Comparator.naturalOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mNum = Integer.parseInt(st.nextToken());

            System.out.println(contains(mNum, 0, n - 1));
        }
    }
}
