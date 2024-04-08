package baekjoon.no11725_트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[] bfs(List<List<Integer>> tree, int root) {
        boolean[] visited = new boolean[tree.size() + 1];
        int[] parents = new int[tree.size() + 1];

        visited[root] = true;
        parents[root] = 0;

        List<Integer> children = tree.get(root);
        Queue<Integer> queue = new LinkedList<>(children);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            List<Integer> adjacentNodes = tree.get(node);
            for (int adjacentNode : adjacentNodes) {
                if (visited[adjacentNode]) {
                    parents[node] = adjacentNode;
                    continue;
                }
                queue.add(adjacentNode);
            }
        }
        return parents;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        int[] parents = bfs(tree, 1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }
}
