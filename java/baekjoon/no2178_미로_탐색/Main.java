package baekjoon.no2178_미로_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // left, right, up, down
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void bfs(int r, int c, int[][] maze, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int column = now[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dRow[i];
                int nextColumn = column + dCol[i];

                if (nextRow < 0 || nextRow > r - 1 || nextColumn < 0 || nextColumn > c - 1) {
                    continue;
                }

                if (visited[nextRow][nextColumn] || maze[nextRow][nextColumn] == 0) {
                    continue;
                }

                queue.add(new int[]{nextRow, nextColumn});
                maze[nextRow][nextColumn] = maze[row][column] + 1;
                visited[nextRow][nextColumn] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = row[j];
            }
        }

        bfs(n, m, maze, new boolean[n][m]);
        System.out.println(maze[n - 1][m - 1]);
    }
}
