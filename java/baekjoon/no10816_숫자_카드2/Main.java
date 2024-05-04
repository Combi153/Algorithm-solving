package baekjoon.no10816_숫자_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer> numbers = new ArrayList<>();

    static int upperBound(int number) {
        int start = 0;
        int end = numbers.size();

        while (start < end) {
            int mid = (start + end) / 2;
            int midNum = numbers.get(mid);

            if (number < midNum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    static int lowerBound(int number) {
        int start = 0;
        int end = numbers.size();

        while (start < end) {
            int mid = (start + end) / 2;
            int midNum = numbers.get(mid);

            if (number > midNum) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers.add(number);
        }
        numbers.sort(Comparator.naturalOrder());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mNum = Integer.parseInt(st.nextToken());

            int upperBound = upperBound(mNum);
            int lowerBound = lowerBound(mNum);

            sb.append(upperBound - lowerBound).append(" ");
        }
        System.out.println(sb);
    }
}
