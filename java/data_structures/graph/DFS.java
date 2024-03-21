package data_structures.graph;

public class DFS {

    static boolean[] visited = new boolean[9];

    // 1 : 2 - 3 - 8
    // 2 : 1 - 6 - 8
    // 3 : 1 - 5
    // 4 : 5 - 7
    // 5 : 3 - 4 - 7
    // 6 : 2
    // 7 : 4 - 5
    // 8 : 1 - 2
    static int[][] graph = {{},
            {2, 3, 8},
            {1, 6, 8},
            {1, 5},
            {5, 7},
            {3, 4, 7},
            {2},
            {4, 5},
            {1, 2}
    };

    static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;

        System.out.print(nodeIndex + " -> ");

        for (int node : graph[nodeIndex]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
