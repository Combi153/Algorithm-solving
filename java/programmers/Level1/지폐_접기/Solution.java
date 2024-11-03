package programmers.Level1.지폐_접기;

public class Solution {
    static int width = 0;
    static int height = 1;

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (!(wallet[width] >= bill[width] && wallet[height] >= bill[height]) && !(wallet[width] >= bill[height]
                && wallet[height] >= bill[width])) {

            if (bill[height] > bill[width]) {
                bill[height] = bill[height] / 2;
            } else {
                bill[width] = bill[width] / 2;
            }
            answer++;
        }

        return answer;
    }
}
