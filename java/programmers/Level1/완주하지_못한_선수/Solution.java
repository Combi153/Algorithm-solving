package 완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static String getNotCompletion(String[] participant, Map<String, Integer> countsByParticipant, Map<String, Integer> countsByCompletion) {
        for (int i = 0; i < participant.length; i++) {
            String name = participant[i];
            int participantCount = countsByParticipant.get(name);
            int completionCount = countsByCompletion.getOrDefault(name, 0);
            if (participantCount != completionCount) {
                return name;
            }
        }
        throw new UnsupportedOperationException();
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> countsByParticipant = new HashMap<>();
        Map<String, Integer> countsByCompletion = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {
            countsByParticipant.put(participant[i], countsByParticipant.getOrDefault(participant[i], 0) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            countsByCompletion.put(completion[i], countsByCompletion.getOrDefault(completion[i], 0) + 1);
        }

        return getNotCompletion(participant, countsByParticipant, countsByCompletion);
    }
}
