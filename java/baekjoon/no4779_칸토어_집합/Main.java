package baekjoon.no4779_칸토어_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String cantor(String n) {
        if (n.length() < 2) {
            return n;
        }

        int length = n.length();
        int v = length / 3;

        int d1 = length - (v * 2);
        int d2 = d1 + v;
        int d3 = d2 + v;

        return cantor(n.substring(0, d1)) + n.substring(d1, d2).replaceAll("-", " ") + cantor(n.substring(d2, d3));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            String x = "-".repeat((int) Math.pow(3, n));
            System.out.println(cantor(x));
        }

        br.close();
    }
}
