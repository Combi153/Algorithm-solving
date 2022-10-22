package date1012_greedy_twopointers.no17609_g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] word;

        for (int i = 0;  i < length; i++) {
            word = br.readLine().split("");
            boolean even = (word.length % 2 == 0);
            int middle = word.length / 2;

            int pointer1 = even ? middle - 1 : middle;
            int pointer2 = middle;
            boolean check = true;
            int cnt = 0;

            while (check && cnt < 2) {
                if (!word[pointer1].equals(word[pointer2])) {
                    if (word[pointer1 - 1].equals(word[pointer2])) {
                        pointer1--;
                        cnt++;
                    } else if(word[pointer1].equals(word[pointer2 - 1])) {
                        pointer2--;
                        cnt++;
                    } else {
                        check = false;
                    }
                } else {
                    if (pointer1 > 0 && pointer2 < word.length) {
                        pointer1--;
                        pointer2++;
                    } else{
                        break;
                    }

                }
            }

            if (check && cnt == 0) {
                System.out.println(0);
            } else if(check && cnt == 1) {
                System.out.println(1);
            } else{
                System.out.println(2);
            }
        }
    }
}
