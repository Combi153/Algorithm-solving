package baekjoon.implementation.no10988_팰린드롬확인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] word = getReadLine().split("");

        int last = word.length - 1;
        int middle = (last + 1) / 2;
        int result = 1;

        for (int i = 0; i < middle; i++) {
            String leftAlphabet = word[i];
            String rightAlphabet = word[last - i];

            if (!leftAlphabet.equals(rightAlphabet)) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    private static String getReadLine() throws IOException {
        return reader.readLine();
    }
}
