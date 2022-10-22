package date1012_greedy_twopointers.no17609_g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17609_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] word;

        for (int i = 0;  i < length; i++) {
            word = br.readLine().split("");

            // 양 끝 인덱스에서 포인터 시작, 중간에서 만나도록 함.
            int pointer1 = 0;
            int pointer2 = word.length - 1;
            boolean check = true;
            int cnt = 0;

            while (check && cnt < 2) {
                if (!word[pointer1].equals(word[pointer2])) { //두 포인터가 가리키는 String 이 서로 다를 때
                    check = false;
                    int middle = word.length / 2;
                    if (word.length % 2 != 0) { //word의 길이가 홀수일 때
                        if (word[middle].equals(word[middle - 1])) {
                            if (word[pointer1].equals(word[pointer2 - 1])) {
                                pointer2--;
                                cnt++;
                                check = true;
                                continue;
                            }
                        }
                        if (word[middle].equals(word[middle + 1])) {
                            if (word[pointer1 + 1].equals(word[pointer2])) {
                                pointer1++;
                                cnt++;
                                check = true;
                            }
                        }
                    } else {                    //word의 길이가 짝수일 때
                        if (pointer2 - pointer1 == 1){
                            cnt++;
                            check = true;
                            break;
                        }

                        if (word[middle].equals(word[middle - 2])){
                           if (word[pointer1].equals(word[pointer2 - 1])) {
                                pointer2--;
                                cnt++;
                                check = true;
                                continue;
                            }
                        }
                        if (word[middle + 1].equals(word[middle - 1])) {
                            if (word[pointer1 + 1].equals(word[pointer2])) {
                                pointer1++;
                                cnt++;
                                check = true;
                            }
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
