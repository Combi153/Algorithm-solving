package date1012_greedy_twopointers.no2559_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] daysAndTarget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] temperatures = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int days = daysAndTarget[0];
        int target = daysAndTarget[1];

        int pointer1 = 0;
        int pointer2 = target;
        int sumOfTemperatures;
        int max = -100_000_000;

        while (pointer2 <= days) {
            sumOfTemperatures = 0;
            for (int i = pointer1; i < pointer2; i++) {
                sumOfTemperatures += temperatures[i];
            }

            if (max < sumOfTemperatures) {
                max = sumOfTemperatures;
            }
            pointer1++;
            pointer2++;
            //System.out.println(sumOfTemperatures);
        }
        System.out.println(max);
        br.close();
    }
}
