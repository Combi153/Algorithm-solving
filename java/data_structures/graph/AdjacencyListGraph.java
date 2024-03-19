package data_structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacencyListGraph {
    private final List<List<Integer>> graph = new ArrayList<>();

    public AdjacencyListGraph(int vectorNum) {
        for (int i = 0; i <= vectorNum; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void putEdge(int x, int y) {
        // 방향 그래프
//        List<Integer> vector = graph.get(x);
//        vector.add(y);

        // 무방향 그래프
        List<Integer> vertexX = graph.get(x);
        List<Integer> vertexY = graph.get(y);
        vertexX.add(y);
        vertexY.add(x);
    }

    public void print() {
        for (int i = 1; i < graph.size(); i++) {
            List<Integer> vertex = graph.get(i);
            String adjacencyVectors = vertex.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("->"));

            System.out.println("vertex" + "[" + i + "] : " + adjacencyVectors);
        }
    }

    public static void main(String[] args) {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);

        graph.putEdge(1, 2);
        graph.putEdge(1, 3);
        graph.putEdge(1, 4);
        graph.putEdge(2, 3);
        graph.putEdge(2, 5);
        graph.putEdge(3, 4);
        graph.putEdge(4, 5);

        graph.print();
    }
}
