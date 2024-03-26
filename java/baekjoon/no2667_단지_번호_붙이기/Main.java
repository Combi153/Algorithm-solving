package baekjoon.no2667_단지_번호_붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    // up, down, left, right
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int count = 0;
    static int num = 0;

    public static void dfs(int r, int c, int[][] houseMap, boolean[][] visited) {
        visited[r][c] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dRow[i];
            int nextC = c + dCol[i];

            if (nextR < 0 || nextR > houseMap.length - 1 || nextC < 0 || nextC > houseMap[0].length - 1) {
                continue;
            }

            if (visited[nextR][nextC] || houseMap[nextR][nextC] == 0) {
                continue;
            }

            dfs(nextR, nextC, houseMap, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] houseMap = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] houses = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                houseMap[i][j] = Integer.parseInt(houses[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (houseMap[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, houseMap, visited);
                    ++num;
                    counts.add(count);
                    count = 0;
                }
            }
        }

        counts.sort(Comparator.naturalOrder());
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            System.out.println(counts.get(i));
        }
    }
}
