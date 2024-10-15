package programmers.Level2.피로도;

public class Solution {

    public int max = 0;

    private void dfs(int k, int[][] dungeons, int depth, boolean[] visited, int count) {
        if (depth == dungeons.length) {
            if (count > max) {
                max = count;
            }
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int min = dungeons[i][0];
                int con = dungeons[i][1];

                if (k >= min) {
                    dfs(k - con, dungeons, depth + 1, visited, count + 1);
                } else {
                    dfs(k, dungeons, depth + 1, visited, count);
                }

                visited[i] = false;
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0, new boolean[dungeons.length], 0);
        return max;
    }
}
