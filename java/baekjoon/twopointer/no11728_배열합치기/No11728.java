package date1012_greedy_twopointers.no11728_b;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class No11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] lengths = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String strArray = br.readLine() + " " + br.readLine();
        List<Integer> array = Arrays.stream(strArray.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Collections.sort(array);

        for (int i = 0; i < array.size(); i++) {

            bw.write(String.valueOf(array.get(i)));

            if (i < lengths[0] + lengths[1] - 1){
                bw.write(" ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
