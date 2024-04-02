package baekjoon.no7562_나이트의_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dR = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dC = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    static int bfs(int[][] board, int sR, int sC, int eR, int eC, int l) {
        if (sR == eR && sC == eC) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        board[sR][sC] = 1;
        queue.add(new int[]{sR, sC});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            int count = board[nowR][nowC];

            for (int i = 0; i < 8; i++) {
                int nextR = nowR + dR[i];
                int nextC = nowC + dC[i];

                if (nextR < 0 || nextR > l - 1 || nextC < 0 || nextC > l - 1) {
                    continue;
                }
                if (board[nextR][nextC] != 0) {
                    continue;
                }
                if (nextR == eR && nextC == eC) {
                    return count;
                }

                board[nextR][nextC] = count + 1;
                queue.add(new int[]{nextR, nextC});
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int l = Integer.parseInt(br.readLine());
            int[][] board = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());

            int count = bfs(board, sR, sC, eR, eC, l);
            System.out.println(count);
        }
    }
}
