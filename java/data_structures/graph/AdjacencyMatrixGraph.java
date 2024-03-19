package data_structures.graph;

public class AdjacencyMatrixGraph {

    private final int[][] graph;

    public AdjacencyMatrixGraph(int vertexNum) {
        this.graph = new int[vertexNum + 1][vertexNum + 1];
    }

    public void putEdge(int x, int y) {
        // 무방향 그래프
        graph[x][y] = 1;
        graph[y][x] = 1;
    }

    public void print() {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);

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
