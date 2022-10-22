package date1004_implementation.no1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1057 {

    static int baseLogCeil(double x, double base) {
        return (int) Math.ceil(Math.log10(x)/Math.log10(base));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numOfRounds = No1057.baseLogCeil(intLine[0], 2.0);
        int player1 = (intLine[1] > intLine[2]) ? intLine[2] : intLine[1];
        int player2 = (intLine[1] > intLine[2]) ? intLine[1] : intLine[2];
        int roundNum = -1;
        int gap;

        if (player1 % 2 != 0){
            gap = 1;
            for (int i = 1; i < numOfRounds + 1; i++) {
                if (player1 - player2 <= gap) {
                    roundNum = i;
                    break;
                } else{
                    gap = (gap * 2) + 1;
                }
            }
        } else{
            gap = 2;
            for (int i = 2; i < numOfRounds + 1; i++) {
                if (player1 - player2 <= gap) {
                    roundNum = i;
                    break;
                } else{
                    gap = (gap * 2) + 2;
                }
            }
        }

        System.out.println(roundNum);




    }
}
