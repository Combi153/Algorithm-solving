package baekjoon.no4134_다음_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isPrimeNumber(long num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        for (long i = 2; i < Math.sqrt(num) + 1L; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long getNearestPrimeNumberGreaterThanOrEqualTo(long num) {
        long a = num;
        while (!isPrimeNumber(a)) {
            a++;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            long num = Long.parseLong(br.readLine());
            long primeNumber = getNearestPrimeNumberGreaterThanOrEqualTo(num);
            System.out.println(primeNumber);
        }
    }
}
