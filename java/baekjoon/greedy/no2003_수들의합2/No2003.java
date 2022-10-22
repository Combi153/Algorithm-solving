package date1012_greedy_twopointers.no2003_i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] countAndTarget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lengthOfNumbers = countAndTarget[0];
        int target = countAndTarget[1];

        int pointer1 = 0;
        int pointer2 = 0;
        int count = 0;
        int result;

        while(pointer1 <= lengthOfNumbers - 1 && pointer2 <= lengthOfNumbers - 1){
            result = 0;

            for (int i = pointer1; i <= pointer2; i++) {
                result += numbers[i];
            }

            if (result < target) {
                if (pointer2 >= lengthOfNumbers - 1) pointer1++;
                else pointer2++;
            } else if (result > target) {
                if (pointer2 == pointer1) pointer2++;
                else pointer1++;
            } else {
                count++;
                pointer2++;
            }
        }
        System.out.println(count);
    }
}