package baekjoon.no1012_유기농_배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // right, left, up, down,
    static int[] dCol = {1, -1, 0, 0};
    static int[] dRow = {0, 0, 1, -1};
    static int cnt = 0;

    static void dfs(int col, int row, int[][] graph, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nextCol = dCol[i] + col;
            int nextRow = dRow[i] + row;

            if (nextCol < 0 || nextCol > graph[0].length - 1 || nextRow < 0 || nextRow > graph.length - 1) {
                continue;
            }

            if (graph[nextRow][nextCol] == 0 || visited[nextRow][nextCol]) {
                continue;
            }

            dfs(nextCol, nextRow, graph, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tn = Integer.parseInt(br.readLine());
        for (int i = 0; i < tn; i++) {
            st = new StringTokenizer(br.readLine());

            int colM = Integer.parseInt(st.nextToken());
            int rowN = Integer.parseInt(st.nextToken());
            int[][] graph = new int[rowN][colM];
            boolean[][] visited = new boolean[rowN][colM];

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                int xM = Integer.parseInt(st.nextToken());
                int yN = Integer.parseInt(st.nextToken());
                graph[yN][xM] = 1;
            }

            for (int j = 0; j < rowN; j++) {
                for (int l = 0; l < colM; l++) {
                    if (graph[j][l] == 1 && !visited[j][l]) {
                        dfs(l, j, graph, visited);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
}
