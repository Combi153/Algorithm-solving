package programmers.Level1.모의고사;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static int poll_check_add(Queue<Integer> giveUpMath, int answer, int mathCount) {
        int mathAnswer = giveUpMath.poll();
        giveUpMath.add(mathAnswer);
        if (answer == mathAnswer) {
            return mathCount + 1;
        }
        return mathCount;
    }

    public int[] solution(int[] answers) {
        Queue<Integer> giveUpMath1 = new LinkedList<>();
        Queue<Integer> giveUpMath2 = new LinkedList<>();
        Queue<Integer> giveUpMath3 = new LinkedList<>();
        int[] giveUpMath3Values = new int[]{3, 1, 2, 4, 5};
        for (int i = 1; i <= 5; i++) {
            giveUpMath1.add(i);

            if (i != 2) {
                giveUpMath2.add(2);
                giveUpMath2.add(i);
            }

            giveUpMath3.add(giveUpMath3Values[i - 1]);
            giveUpMath3.add(giveUpMath3Values[i - 1]);
        }

        int mathCount1 = 0;
        int mathCount2 = 0;
        int mathCount3 = 0;

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            mathCount1 = poll_check_add(giveUpMath1, answer, mathCount1);
            mathCount2 = poll_check_add(giveUpMath2, answer, mathCount2);
            mathCount3 = poll_check_add(giveUpMath3, answer, mathCount3);
        }
        int[] mathCounts = new int[]{mathCount1, mathCount2, mathCount3};

        int maxCount = 0;
        for (int i = 0; i < mathCounts.length; i++) {
            if (mathCounts[i] > maxCount) {
                maxCount = mathCounts[i];
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < mathCounts.length; i++) {
            if (mathCounts[i] == maxCount) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
