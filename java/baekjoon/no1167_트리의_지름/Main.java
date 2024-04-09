package baekjoon.no1167_트리의_지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int max = 0;
    static int maxNode = 0;

    static class Node {
        int number;
        int distance;

        public Node(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", distance=" + distance +
                    '}';
        }
    }

    public static void dfs(List<List<Node>> tree, int node, int distance, boolean[] visited) {
        if (distance > max) {
            max = distance;
            maxNode = node;
        }

        visited[node] = true;
        List<Node> nodes = tree.get(node);

        for (Node adjacentNode : nodes) {
            if (!visited[adjacentNode.number]) {
                dfs(tree, adjacentNode.number, distance + adjacentNode.distance, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());

        List<List<Node>> tree = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int adjacentNode = Integer.parseInt(st.nextToken());
                if (adjacentNode == -1) {
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());

                tree.get(node).add(new Node(adjacentNode, weight));
            }
        }

        dfs(tree, 1, 0, new boolean[v + 1]);
        dfs(tree, maxNode, 0, new boolean[v + 1]);

        System.out.println(max);
    }
}
