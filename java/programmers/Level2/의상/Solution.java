package 의상;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> countByClothType = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String clothType = clothes[i][1];
            countByClothType.put(clothType, countByClothType.getOrDefault(clothType, 0) + 1);
        }

        int answer = 1;

        for (int count : countByClothType.values()) {
            answer *= (count + 1);
        }

        return answer - 1;
    }
}
