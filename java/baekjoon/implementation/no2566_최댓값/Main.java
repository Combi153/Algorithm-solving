package date1004_implementation.no2566_최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final BufferedReader bufferedReader;

    public Main(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void findMaxValueAndPrint() throws IOException {
        List<List<Integer>> matrix = readMatrix();
        Map<Integer, List<Integer>> maxValueAndPosition = findMaxValueAndPosition(matrix);
    }

    private Map<Integer, List<Integer>> findMaxValueAndPosition(List<List<Integer>> matrix) {
        Map<Integer, List<Integer>> maxValueAndPosition = new HashMap<>();
        int matrixMax = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < matrix.size(); i++) {
            int rowMax = Collections.max(matrix.get(i));
            if (matrixMax < rowMax) {
                matrixMax = rowMax;
                row = i;
                column = matrix.get(i).indexOf(matrixMax);
            }
        }
        System.out.println(matrixMax);
        System.out.println(row +" " + column);
        return maxValueAndPosition;
    }

    private List<List<Integer>> readMatrix() throws IOException {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            matrix.add(readRow());
        }
        return matrix;
    }

    private List<Integer> readRow() throws IOException {
        String line = bufferedReader.readLine();
        return Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
