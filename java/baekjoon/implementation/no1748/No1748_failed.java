package date1004_implementation.no1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
메모리 초과
*/

public class No1748_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        String str;
        for (int i = 1; i < num + 1; i++) {
            str = Integer.toString(i);
            sb.append(str);
        }
        System.out.println(sb.length());
        br.close();
    }
}
