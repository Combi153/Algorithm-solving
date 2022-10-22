package date1012_greedy_twopointers.no1541_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class No1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        int[] numbers = Arrays.stream(expression.split("\\D+")).mapToInt(Integer::parseInt).toArray();
        List<String> operators = new ArrayList<>(Arrays.asList(expression.split("\\d+")));

        if (operators.size() > 0) {
            operators.set(0, "+");
        } else {
            operators.add("+");
        }

        int sum = 0;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (operators.get(i).equals("-")) {
                operators.set(i + 1, "-");
            }
        }

         for (int i = 0; i < numbers.length; i++) {
             if (operators.get(i).equals("-")) {
                 sum -= numbers[i];
             } else {
                 sum += numbers[i];
             }
         }
        System.out.println(sum);
    }
}
