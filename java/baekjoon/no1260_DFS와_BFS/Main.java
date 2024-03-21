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

public class Main {

    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited, StringBuilder sb) {
        visited[node] = true;
        sb.append(node).append(" ");

        List<Integer> adjacencyNodes = graph.get(node);

        for (Integer adjacencyN : adjacencyNodes) {
            if (!visited[adjacencyN]) {
                dfs(adjacencyN, graph, visited, sb);
            }
        }
    }

    public static void bfs(int node, List<List<Integer>> graph, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();

        sb.append(node).append(" ");
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            List<Integer> adjacencyNodes = graph.get(queue.poll());

            for (Integer adjacencyNode : adjacencyNodes) {
                if (!visited[adjacencyNode]) {
                    visited[adjacencyNode] = true;
                    sb.append(adjacencyNode).append(" ");
                    queue.offer(adjacencyNode);
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

        for (int i = 0; i < edge_c; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int adjacencyN = Integer.parseInt(st.nextToken());

            graph.get(n).add(adjacencyN);
            graph.get(adjacencyN).add(n);
        }

        for (List<Integer> adjacencyNs : graph) {
            adjacencyNs.sort(Comparator.naturalOrder());
        }

        StringBuilder sb = new StringBuilder();
        dfs(startVertex, graph, new boolean[vertex_c + 1], sb);
        sb.append("\n");
        bfs(startVertex, graph, new boolean[vertex_c + 1], sb);

        System.out.println(sb);
    }
}
