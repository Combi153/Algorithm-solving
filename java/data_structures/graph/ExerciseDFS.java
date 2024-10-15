package data_structures.graph;

public class ExerciseDFS {

    static void dfs(int nodeIndex, int[][] graph, boolean[] visited) {
        visited[nodeIndex] = true;
        System.out.print(nodeIndex + " -> ");
        for (int node : graph[nodeIndex]) {
            if (!visited[node]) {
                dfs(node, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 6, 8},
                {1, 5},
                {5, 7},
                {3, 4, 7},
                {2},
                {4, 5},
                {1, 2}
        };
        boolean[] visited = new boolean[graph.length];

        dfs(1, graph, visited);

    }
}
