package baekjoon.no10816_숫자_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, Integer> nByCount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (nByCount.containsKey(number)) {
                nByCount.put(number, nByCount.get(number) + 1);
            } else {
                nByCount.put(number, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int mNum = Integer.parseInt(st.nextToken());

            sb.append(nByCount.getOrDefault(mNum, 0)).append(" ");
        }
        System.out.println(sb);
    }
}
