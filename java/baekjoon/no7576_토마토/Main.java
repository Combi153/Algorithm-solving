package baekjoon.no7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int count = 0;
    static int[] dRow = {1, -1, 0, 0};
    static int[] dCol = {0, 0, 1, -1};

    static void bfs(Queue<int[]> queue, int[][] graph, boolean[][] visited) {
        while (!queue.isEmpty()) {
            int[] nowPoint = queue.poll();
            int nowRow = nowPoint[0];
            int nowCol = nowPoint[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = dRow[i] + nowRow;
                int nextCol = dCol[i] + nowCol;

                if (nextRow < 0 || nextRow > graph.length - 1 || nextCol < 0 || nextCol > graph[0].length - 1) {
                    continue;
                }

                if (graph[nextRow][nextCol] != 0 || visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                graph[nextRow][nextCol] = graph[nowRow][nowCol] + 1;
                queue.add(new int[]{nextRow, nextCol});
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int columnM = Integer.parseInt(st.nextToken());
        int rowN = Integer.parseInt(st.nextToken());

        int[][] graph = new int[rowN][columnM];
        boolean[][] visited = new boolean[rowN][columnM];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rowN; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < columnM; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                graph[i][j] = tomato;
                if (tomato == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        bfs(queue, graph, visited);

        int max = -1;
        for (int i = 0; i < rowN; i++) {
            for (int tomato : graph[i]) {
                max = Math.max(tomato, max);
                if (tomato == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(max - 1);
    }
}
