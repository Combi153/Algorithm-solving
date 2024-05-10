package programmers.Level1.폰켓몬;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2;

        Set<Integer> types = new HashSet<>();
        for (int num : nums) {
            types.add(num);
        }

        return Math.min(n, types.size());
    }
}
