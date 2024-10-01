package data_structures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GraphExerciseList {

    private final List<List<Integer>> graph = new ArrayList<>();

    public GraphExerciseList(int vertex_count) {
        for (int i = 0; i <= vertex_count; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void putEdge(int x, int y) {
        List<Integer> vertexesX = graph.get(x);
        List<Integer> vertexesY = graph.get(y);

        vertexesX.add(y);
        vertexesY.add(x);
    }

    public void printGraph() {
        for (int i = 1; i < graph.size(); i++) {
            String vertexes = graph.get(i).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("vertexes[" + i + "]: " + vertexes);
        }
    }

    public static void main(String[] args) {
        GraphExerciseList graphExerciseList = new GraphExerciseList(5);

        graphExerciseList.putEdge(1, 2);
        graphExerciseList.putEdge(1, 4);
        graphExerciseList.putEdge(2, 5);
        graphExerciseList.putEdge(3, 4);
        graphExerciseList.putEdge(3, 5);

        graphExerciseList.printGraph();
    }
}
