package baekjoon.no1260_DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static void dfs(int startNode, List<List<Integer>> graph, boolean[] visited) {
        visited[startNode] = true;
        System.out.print(startNode + " ");
        for (int adjacencyNode : graph.get(startNode)) {
            if (!visited[adjacencyNode]) {
                dfs(adjacencyNode, graph, visited);
            }
        }
    }

    public static void bfs(int startNode, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int adjacencyNode : graph.get(node)) {
                if (!visited[adjacencyNode]) {
                    visited[adjacencyNode] = true;
                    queue.add((adjacencyNode));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertex_c = Integer.parseInt(st.nextToken());
        int edge_c = Integer.parseInt(st.nextToken());
        int startVertex = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertex_c; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= edge_c; i++) {
            StringTokenizer st1 = new StringTokenizer((br.readLine()));
            int node = Integer.parseInt(st1.nextToken());
            int adjacencyNode = Integer.parseInt(st1.nextToken());

            graph.get(node).add(adjacencyNode);
            graph.get(adjacencyNode).add(node);
        }

        for (List<Integer> integers : graph) {
            integers.sort(Comparator.naturalOrder());
        }

        dfs(startVertex, graph, new boolean[graph.size()]);
        System.out.println();
        bfs(startVertex, graph, new boolean[graph.size()]);
    }
}
