package date1012_greedy_twopointers.no17609_g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17609_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] word;

        for (int i = 0;  i < length; i++) {
            word = br.readLine().split("");

            int pointer1 = 0;
            int pointer2 = word.length - 1;
            boolean check = true;
            int cnt = 0;

            while (check && cnt < 2) {
                if (!word[pointer1].equals(word[pointer2])) {
                    check = false;
                    if (word[pointer1 + 1].equals(word[pointer2])) {
                        if (pointer1 + 1 == pointer2) {
                            pointer1++;
                            cnt++;
                            check = true;
                            continue;
                        } else if (word[pointer1 + 2].equals(word[pointer2 - 1])) {
                            pointer1++;
                            cnt++;
                            check = true;
                            continue;
                        }
                    }
                    if(word[pointer1].equals(word[pointer2 - 1])) {
                        if (pointer1 == pointer2 - 1) {
                            pointer2--;
                            cnt++;
                            check = true;
                        } else if (word[pointer1 + 1].equals(word[pointer2 - 2])) {
                            pointer2--;
                            cnt++;
                            check = true;
                        }
                    }

                } else {
                    pointer1++;
                    pointer2--;
                    if (pointer1 >= pointer2) break;
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
