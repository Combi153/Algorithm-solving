package baekjoon.no4779_칸토어_집합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void cantor(boolean[] x, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int v = (end - start) / 3;
        int d1 = start + v;
        int d2 = end - v;

        for (int i = d1; i < d2; i++) {
            x[i] = true;
        }

        cantor(x, start, d1);
        cantor(x, d2, end);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while ((s = br.readLine()) != null) {
            int n = (int) Math.pow(3, Integer.parseInt(s));
            boolean[] x = new boolean[n];
            cantor(x, 0, x.length);

            for (boolean b : x) {
                if (b) {
                    bw.write(" ");
                    continue;
                }
                bw.write("-");
            }
            bw.newLine();
            bw.flush();
        }
        
        br.close();
        bw.close();
    }
}
