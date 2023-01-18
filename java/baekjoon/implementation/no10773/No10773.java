package implementation.no10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());

        int number;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            number = Integer.parseInt(br.readLine());
            if (number != 0){
                numbers.add(number);
                idx++;
            } else{
                numbers.remove(idx - 1);
                idx--;
            }
        }
        System.out.println(numbers.stream().mapToInt(num -> num).summaryStatistics().getSum());
    }
}
