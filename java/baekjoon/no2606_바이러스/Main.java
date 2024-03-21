package baekjoon.no2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int count = -1;

    public static void dfs(int nodeIndex, boolean[] visited, List<List<Integer>> graph) {
        visited[nodeIndex] = true;
        count++;

        for (Integer node : graph.get(nodeIndex)) {
            if (!visited[node]) {
                dfs(node, visited, graph);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v_count = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= v_count; i++) {
            graph.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[v_count + 1];
        int e_count = Integer.parseInt(br.readLine());

        for (int i = 0; i < e_count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer> vertexN = graph.get(n);
            List<Integer> vertexM = graph.get(m);
            vertexN.add(m);
            vertexM.add(n);
        }

        dfs(1, visited, graph);

        System.out.println(count);
    }
}
