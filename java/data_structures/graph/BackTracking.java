package data_structures.graph;

public class BackTracking {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2, 4, 3}, {1, 3, 7}, {6, 5, 6}};
        boolean[] visited = new boolean[matrix.length];

        BackTracking backTracking = new BackTracking();
        backTracking.backTracking(0, 0, visited, matrix);
    }

    public void backTracking(int row, int score, boolean[] visited, int[][] matrix) {
        if (row == 3) {
            System.out.println(score);
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int num = matrix[row][i];
                backTracking(row + 1, score + num, visited, matrix);
                visited[i] = false;
            }
        }
    }
}
