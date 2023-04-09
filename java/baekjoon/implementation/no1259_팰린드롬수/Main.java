package baekjoon.implementation.no1259_팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public void run() throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number;
        while (true) {
            number = bufferedReader.readLine();
            if (number.equals("0")) {
                break;
            }

            if (isPalindrome(number)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private boolean isPalindrome(final String number) {
        final ArrayDeque<String> numbers = Arrays.stream(number.split("")).collect(Collectors.toCollection(ArrayDeque::new));

        while (numbers.size() > 1) {
            final String first = numbers.pollFirst();
            final String last = numbers.pollLast();
            if (!first.equals(last)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        final Main main = new Main();
        main.run();
    }
}
