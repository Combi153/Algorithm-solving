package data_structures.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static String bfs(int startNode, int[][] graph, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" -> ");
            int[] adjacencyNodes = graph[node];

            for (int adjacencyNode : adjacencyNodes) {
                if (!visited[adjacencyNode]) {
                    visited[adjacencyNode] = true;
                    queue.offer(adjacencyNode);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 1 : 2 - 3 - 8
        // 2 : 1 - 6 - 8
        // 3 : 1 - 5
        // 4 : 5 - 7
        // 5 : 3 - 4 - 7
        // 6 : 2
        // 7 : 4 - 5
        // 8 : 1 - 2
        int[][] graph = {{},
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

        String bfs = bfs(1, graph, visited);
        System.out.println(bfs);
    }
}
