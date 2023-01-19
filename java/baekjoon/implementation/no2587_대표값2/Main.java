package implementation.no2587_대표값2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private final BufferedReader bufferedReader;

    public Main(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public List<Integer> readNumbers(int size) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int number = readNumber();
            numbers.add(number);
        }
        return numbers;
    }

    private int readNumber() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void calculateStatisticsOf(List<Integer> numbers) {
        int mean = calculateMean(numbers);
        int median = calculateMedian(numbers);

        System.out.println(mean);
        System.out.println(median);
    }

    private int calculateMean(List<Integer> numbers) {
        return sum(numbers) / numbers.size();
    }

    private int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private int calculateMedian(List<Integer> numbers) {
        Collections.sort(numbers);
        int middleOrder = calculateMiddleOrder(numbers);
        return numbers.get(middleOrder);
    }

    private int calculateMiddleOrder(List<Integer> numbers) {
        return numbers.size() / 2;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        List<Integer> numbers = main.readNumbers(5);
        main.calculateStatisticsOf(numbers);
    }
}