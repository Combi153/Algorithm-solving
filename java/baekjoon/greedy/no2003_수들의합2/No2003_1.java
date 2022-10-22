package date1012_greedy_twopointers.no2003_i;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2003_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] countAndTarget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lengthOfNumbers = countAndTarget[0];
        int target = countAndTarget[1];

        int pointer1 = 0;
        int pointer2 = 1;
        int count = 0;
        int result = numbers[pointer1] + numbers[pointer2];

        while(pointer2 <= lengthOfNumbers){

            if ((result == target) && (pointer2 < lengthOfNumbers - 1)) {
                count++;
                pointer1++;
                pointer2++;
                result += numbers[pointer2] - numbers[pointer1 - 1];
            } else if ((result == target) && (pointer2 == lengthOfNumbers - 1)) {
                count++;
                break;
            } else if ((result < target) && (pointer2 < lengthOfNumbers - 1)){
                pointer2++;
                result += numbers[pointer2];
            } else if ((result < target) && (pointer2 == lengthOfNumbers - 1)){
                break;
            } else if ((result > target) && (pointer2 - pointer1 != 1)) {
                pointer1++;
                result -= numbers[pointer1 - 1];
            } else if ((result > target) && (pointer2 - pointer1 == 1)) {
                pointer1++;
                pointer2++;
                result += numbers[pointer2] - numbers[pointer1 - 1];
            }
        }
        System.out.println(count);
    }
}