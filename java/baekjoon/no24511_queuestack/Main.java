package baekjoon.no24511_queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");

        int n = Integer.parseInt(br.readLine());
        StringTokenizer aST = new StringTokenizer(br.readLine());
        StringTokenizer bST = new StringTokenizer(br.readLine());

        Deque<String> b = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (aST.nextToken().equals("0")) {
                b.addLast(bST.nextToken());
                continue;
            }
            bST.nextToken();
        }

        int cnt = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        for (int i = 0; i < cnt; i++) {
            b.addFirst(numbers[i]);
            sj.add(b.pollLast());
        }

        br.close();
        System.out.println(sj);
    }
}
