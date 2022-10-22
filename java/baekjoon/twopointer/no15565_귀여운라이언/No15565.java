package date1012_greedy_twopointers.no15565_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] lengthAndTarget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] dolls = br.readLine().split(" ");
        List<Integer> lionIdx = new ArrayList<>();

        int length = lengthAndTarget[0];
        int target = lengthAndTarget[1];

        for (int i = 0; i < length; i++) {
            if (dolls[i].equals("1")){
                lionIdx.add(i);
            }
        }

        int pointer1 = 0;
        int pointer2 = target - 1;
        int minLength = (target > lionIdx.size()) ? -1 : 10_000_000;
        int setSize;

        while (pointer2 < lionIdx.size() && minLength != -1) {
            setSize = lionIdx.get(pointer2) - lionIdx.get(pointer1) + 1;
            if (minLength > (setSize)) {
                minLength = setSize;
            }
            pointer1++;
            pointer2++;
        }
        System.out.println(minLength);
    }
}
