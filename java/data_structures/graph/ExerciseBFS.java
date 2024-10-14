package data_structures.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ExerciseBFS {
    static void bfs(int nodeIndex, int[][] graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(nodeIndex);
        visited[nodeIndex] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            int[] adjacencyNodes = graph[node];
            for (int adjacencyNode : adjacencyNodes) {
                if (!visited[adjacencyNode]) {
                    visited[node] = true;
                    queue.add(adjacencyNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {},
                {2, 3, 8}, // 1
                {1, 6, 8}, // 2
                {1, 5}, // 3
                {5, 7}, // 4
                {3, 4, 7}, // 5
                {2}, // 6
                {4, 5}, // 7
                {1, 2} // 8
        };
        boolean[] visited = new boolean[graph.length];

        bfs(1, graph, visited);

    }
}
