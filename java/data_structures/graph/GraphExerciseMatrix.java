package data_structures.graph;

public class GraphExerciseMatrix {

    private final int[][] graph;

    public GraphExerciseMatrix(int vertex_count) {
        this.graph = new int[vertex_count + 1][vertex_count + 1];
    }

    public void putEdge(int x, int y) {
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public void printGraph() {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphExerciseMatrix graph = new GraphExerciseMatrix(5);

        graph.putEdge(1, 2);
        graph.putEdge(1, 4);
        graph.putEdge(3, 4);
        graph.putEdge(2, 5);
        graph.putEdge(3, 5);

        graph.printGraph();
    }
}
