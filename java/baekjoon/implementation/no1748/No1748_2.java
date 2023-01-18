package implementation.no1748;

import java.io.*;

public class No1748_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String n = br.readLine();
        int nLength = n.length();
        int number = Integer.parseInt(n);

        int numLengthCnt = 9;
        int numCriteria = 9;
        int accumulateCnt = 0;
        int cnt = 0;


        for (int i = 1; i < nLength + 1; i++){
            if (number > numCriteria){
                cnt += numLengthCnt * i;
                accumulateCnt += numLengthCnt;
                numLengthCnt *= 10;
                numCriteria += numLengthCnt;
            } else{
                cnt += (number - accumulateCnt) * i;
            }
        }

        wr.write(Integer.toString(cnt));
        br.close();
        wr.close();
    }
}
