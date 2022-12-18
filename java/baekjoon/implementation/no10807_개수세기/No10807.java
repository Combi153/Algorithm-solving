package baekjoon.no10807_개수세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class No10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        String numbersLine = bufferedReader.readLine();
        List<Integer> numbers = Arrays.stream(numbersLine.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int targetNumber = Integer.parseInt(bufferedReader.readLine());

        int answer = Collections.frequency(numbers, targetNumber);
        System.out.println(answer);
    }
}
