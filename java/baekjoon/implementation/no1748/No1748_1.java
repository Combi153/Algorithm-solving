package implementation.no1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No1748_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nLength = Integer.toString(n).length();

        int numLengthCnt = 9;
        int numCriteria = 9;
        int accumulateCnt = 0;
        int cnt = 0;

        for (int i = 1; i < nLength + 1; i++){
            if (n > numCriteria){
                cnt += numLengthCnt * i;
                accumulateCnt += numLengthCnt;
                numLengthCnt *= 10;
                numCriteria += numLengthCnt;
            } else{
                cnt += (n - accumulateCnt) * i;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
