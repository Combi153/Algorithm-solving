package baekjoon.no27433_팩토리얼2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long factorial(long n) {
        if (n < 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        System.out.println(factorial(n));

        br.close();
    }
}
