package baekjoon.binary.no2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(getReadLine());
        int[] requestBudgets = Arrays.stream(getReadLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        int availableBudget = Integer.parseInt(getReadLine());

        int low = 0;
        int high = requestBudgets[count - 1];
        int answer = 0;
        int mid;
        int sum;

        while (low <= high) {
            mid = (low + high) / 2;
            sum = 0;

            for (int requestBudget : requestBudgets) {
                sum += Math.min(requestBudget, mid);
            }

            if (sum > availableBudget) {
                high = mid - 1;
            } else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
        System.out.println(answer);
    }

    private static String getReadLine() throws IOException {
        return reader.readLine();
    }
}
