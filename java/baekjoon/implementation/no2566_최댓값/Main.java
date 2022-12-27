package date1004_implementation.no2566_최댓값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final int ROW_SIZE = 9;
    private static final int INDEX_ADJUSTMENT = 1;
    private static final int INITIAL_VALUE = 0;
    private static final String DELIMITER = " ";
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
        for (int i = 0; i < ROW_SIZE; i++) {
            matrix.add(readRowValues());
        }
        return matrix;
    }

    private List<Integer> readRowValues() throws IOException {
        String line = bufferedReader.readLine();
        return Arrays.stream(line.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> findMaxValueAndPosition(List<List<Integer>> matrix) {
        Map<Integer, List<Integer>> maxValueAndPosition = new HashMap<>();
        int matrixMax = INITIAL_VALUE;
        int row = INITIAL_VALUE;
        int column = INITIAL_VALUE;
        for (int i = 0; i < ROW_SIZE; i++) {
            int rowMax = Collections.max(matrix.get(i));
            if (matrixMax <= rowMax) {
                matrixMax = rowMax;
                row = i + INDEX_ADJUSTMENT;
                column = matrix.get(i).indexOf(matrixMax) + INDEX_ADJUSTMENT;
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
                .collect(Collectors.joining(DELIMITER));
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        main.findMaxValueAndPrint();
    }
}
