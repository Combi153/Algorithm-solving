package programmers.Level1.삼총사;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            int x = number[i];

            for (int j = i + 1; j < number.length - 1; j++) {
                int y = number[j];

                for (int k = j + 1; k < number.length; k++) {
                    int z = number[k];

                    if (x + y + z == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(
                "solution.solution(new int[]{-2, 3, 0, 2, -5}) = " + solution.solution(new int[]{-2, 3, 0, 2, -5})
        );
        System.out.println(
                "solution.solution(new int[]{-3, -2, -1, 0, 1, 2, 3}) = " + solution.solution(
                        new int[]{-3, -2, -1, 0, 1, 2, 3})
        );
        System.out.println(
                "solution.solution(new int[]{-1, 1, -1, 1}) = " + solution.solution(new int[]{-1, 1, -1, 1})
        );
    }
}
