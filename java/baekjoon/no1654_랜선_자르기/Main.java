package baekjoon.no1654_랜선_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static long searchMax(long start, long end, List<Integer> lines, int n) {
        long max = 0;
        while (start <= end) {
            long mid = (start + end) / 2;

            if (canMakeN(lines, mid, n)) {
                start = mid + 1;
                max = mid;
            } else {
                end = mid - 1;
            }
        }

        return max;
    }

    public static boolean canMakeN(List<Integer> lines, long length, int n) {
        int count = 0;
        for (int lan : lines) {
            count += (lan / length);
        }
        return count >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> lines = new ArrayList<>();
        long totalLength = 0;
        for (int i = 0; i < k; i++) {
            int lan = Integer.parseInt(br.readLine());
            totalLength += lan;
            lines.add(lan);
        }

        long max = searchMax(1L, totalLength / n, lines, n);
        System.out.println(max);
    }
}
