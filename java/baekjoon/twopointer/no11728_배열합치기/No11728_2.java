package date1012_greedy_twopointers.no11728_b;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class No11728_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> aArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> bArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Collections.sort(aArray);
        Collections.sort(bArray);

        long firstValueA;
        long firstValueB;

        for (int i = 0; i < lengths[0] + lengths[1]; i++) {
            firstValueA = !aArray.isEmpty() ? aArray.get(0) : 10_000_000_001L;
            firstValueB = !bArray.isEmpty() ? bArray.get(0) : 10_000_000_001L;

            if (firstValueA < firstValueB) {
                bw.write(String.valueOf(aArray.remove(0)));

            } else{
                bw.write(String.valueOf(bArray.remove(0)));
            }

            if (i < lengths[0] + lengths[1] - 1){
                bw.write(" ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
