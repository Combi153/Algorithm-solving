package date1004_implementation.no2566_최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        for (Integer maxValue : maxValueAndPosition.keySet()) {
            printResult(maxValueAndPosition, maxValue);
        }
    }

    private List<List<Integer>> readMatrix() throws IOException {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            matrix.add(readRowValues());
        }
        return matrix;
    }

    private List<Integer> readRowValues() throws IOException {
        String line = bufferedReader.readLine();
        return Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> findMaxValueAndPosition(List<List<Integer>> matrix) {
        Map<Integer, List<Integer>> maxValueAndPosition = new HashMap<>();
        int matrixMax = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < matrix.size(); i++) {
            int rowMax = Collections.max(matrix.get(i));
            if (matrixMax <= rowMax) {
                matrixMax = rowMax;
                row = i + 1;
                column = matrix.get(i).indexOf(matrixMax) + 1;
            }
        }
        maxValueAndPosition.put(matrixMax, List.of(row, column));
        return maxValueAndPosition;
    }

    private void printResult(Map<Integer, List<Integer>> maxValueAndPosition, Integer maxValue) {
        System.out.println(maxValue);
        System.out.println(makePositionMessage(maxValueAndPosition.get(maxValue)));
    }

    private String makePositionMessage(List<Integer> rowAndColumn) {
        return rowAndColumn.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        main.findMaxValueAndPrint();
    }
}
