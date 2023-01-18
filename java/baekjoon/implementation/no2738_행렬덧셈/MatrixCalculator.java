package implementation.no2738_행렬덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixCalculator {

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";
    private static final int ROW_INDEX = 0;
    private static final int COLUMN_INDEX = 1;
    private final BufferedReader bufferedReader;
    private int rowSize;
    private int columnSize;

    public MatrixCalculator(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void printSummationResult() throws IOException {
        readSizes();
        List<List<Integer>> resultMatrix = addMatrix(readMatrix(rowSize), readMatrix(rowSize));
        printMatrix(resultMatrix);
    }

    private void readSizes() throws IOException {
        String line = bufferedReader.readLine();
        List<Integer> sizes = Arrays.stream(line.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.rowSize = sizes.get(ROW_INDEX);
        this.columnSize = sizes.get(COLUMN_INDEX);
    }

    private List<List<Integer>> readMatrix(int rowSize) throws IOException {
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            matrix.add(readRow());
        }
        return matrix;
    }

    private List<Integer> readRow() throws IOException {
        String line = bufferedReader.readLine();
        return Arrays.stream(line.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<List<Integer>> addMatrix(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        List<List<Integer>> newMatrix = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            List<Integer> newRow = addRow(matrixA.get(i), matrixB.get(i));
            newMatrix.add(newRow);
        }
        return newMatrix;
    }

    private List<Integer> addRow(List<Integer> rowOfA, List<Integer> rowOfB) {
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < columnSize; i++) {
            int summation = rowOfA.get(i) + rowOfB.get(i);
            newRow.add(summation);
        }
        return newRow;
    }

    private void printMatrix(List<List<Integer>> resultMatrix) {
        String message = resultMatrix.stream()
                .map(row -> row.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(DELIMITER)))
                .collect(Collectors.joining(NEW_LINE));
        System.out.println(message);
    }

    public static void main(String[] args) throws IOException {
        MatrixCalculator calculator = new MatrixCalculator(new BufferedReader(new InputStreamReader(System.in)));
        calculator.printSummationResult();
    }
}
