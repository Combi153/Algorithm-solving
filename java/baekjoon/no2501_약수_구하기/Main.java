package baekjoon.no2501_약수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = 0;
        int cnt = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                cnt++;
            }
            if (cnt == b) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);

        br.close();
    }
}
