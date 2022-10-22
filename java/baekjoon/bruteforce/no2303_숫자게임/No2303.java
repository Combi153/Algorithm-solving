package date1020_bruteforce.no2303_b_숫자게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2303 {

    BufferedReader br;
    private int winner = 0;

    public No2303() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private String input() throws IOException {
        return br.readLine();
    }

    private int setPlayerNumber() {
        try {
            return Integer.parseInt(input());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] giveCard() {
        try {
            return Arrays.stream(input().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int checkMax(int[] cards) {
        int max = 0;
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    String value = Integer.toString(cards[i] + cards[j] + cards[k]);
                    int lastNumber = value.charAt(value.length() - 1);
                    if (max < lastNumber) max = lastNumber;
                }
            }
        }
        return max;
    }

    private void printWinner() {
        System.out.println(this.winner);
    }

    public void gameStart() {
        int number = setPlayerNumber();
        int max = 0;
        for (int i = 0; i < number; i++) {
            int maxNum = checkMax(giveCard());
            if (max <= maxNum) {
                max = maxNum;
                this.winner = i + 1;
            }
        }
        printWinner();
    }

    public static void main(String[] args) {
        No2303 solution = new No2303();
        solution.gameStart();
    }
}
