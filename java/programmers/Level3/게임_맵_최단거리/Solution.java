package programmers.Level3.게임_맵_최단거리;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] ROW_DIRECTION = {-1, 1, 0, 0};
    static int[] COL_DIRECTION = {0, 0, -1, 1};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    public int solution(int[][] maps) {
        return bfs(0, 0, maps, new boolean[maps.length][maps[0].length]);
    }

    private int bfs(int row, int column, int[][] maps, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        visited[row][column] = true;
        queue.add(new Node(row, column, 1));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getRow() == maps.length - 1 && node.getCol() == maps[0].length - 1) {
                return node.getStage();
            }

            for (int i = 0; i < ROW_DIRECTION.length; i++) {
                int nextRow = node.getRow() + ROW_DIRECTION[i];
                int nextCol = node.getCol() + COL_DIRECTION[i];

                if (canMove(maps, visited, nextRow, nextCol)) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Node(nextRow, nextCol, node.stage + 1));
                }
            }
        }
        return -1;
    }

    private boolean canMove(int[][] maps, boolean[][] visited, int row, int col) {
        return row >= 0 && row <= maps.length - 1 && col >= 0 && col <= maps[0].length - 1
                && maps[row][col] == 1 && !visited[row][col];
    }

    class Node {
        private final int row;
        private final int col;
        private final int stage;

        public Node(int row, int col, int stage) {
            this.row = row;
            this.col = col;
            this.stage = stage;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }

        public int getStage() {
            return stage;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", stage=" + stage +
                    '}';
        }
    }

}
