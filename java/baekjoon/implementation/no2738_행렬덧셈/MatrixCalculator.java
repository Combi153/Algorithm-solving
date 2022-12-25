package date1004_implementation.no2738_행렬덧셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixCalculator {

    private final BufferedReader bufferedReader;
    private int rowSize;
    private int columnSize;

    public MatrixCalculator(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void printSummationResult() throws IOException {
        readSizes();
        List<List<Integer>> resultMatrix = addMatrix(readMatrix(rowSize), readMatrix(rowSize));
        for (int i = 0; i < rowSize; i++) {
            List<Integer> row = resultMatrix.get(i);
            for (int j = 0; j < columnSize; j++) {
                System.out.print(row.get(j));
            }
            if (i != rowSize - 1) {
                System.out.println();
            }
        }
    }

    private void readSizes() throws IOException {
        String line = bufferedReader.readLine();
        List<Integer> sizes = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.rowSize = sizes.get(0);
        this.columnSize = sizes.get(1);
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
        return Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<List<Integer>> addMatrix(List<List<Integer>> matrixA, List<List<Integer>> matrixB) {
        List<List<Integer>> newMatrix = new ArrayList<>();
        for (int i = 0; i < matrixA.size(); i++) {
            List<Integer> newRow = addRow(matrixA.get(i), matrixB.get(i));
            newMatrix.add(newRow);
        }
        return newMatrix;
    }

    private List<Integer> addRow(List<Integer> rowOfA, List<Integer> rowOfB) {
        List<Integer> newRow = new ArrayList<>();
        for (int i = 0; i < rowOfA.size(); i++) {
            int summation = rowOfA.get(i) + rowOfB.get(i);
            newRow.add(summation);
        }
        return newRow;
    }

    public static void main(String[] args) throws IOException {
        MatrixCalculator calculator = new MatrixCalculator(new BufferedReader(new InputStreamReader(System.in)));
        calculator.printSummationResult();
    }
}
