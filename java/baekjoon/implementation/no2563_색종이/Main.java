package implementation.no2563_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private final BufferedReader bufferedReader;

    public Main(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int measureArea() throws IOException {
        List<List<Boolean>> bigPaper = makeBigPaper();

        int count = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < count; i++) {
            List<Integer> location = readLocationOfColoredPaper();
            checkArea(bigPaper, location);
        }

        return measureAreaOfColoredPaper(bigPaper);
    }

    private List<Integer> readLocationOfColoredPaper() throws IOException {
        String locationOfPaper = bufferedReader.readLine();
        return Arrays.stream(locationOfPaper.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<List<Boolean>> makeBigPaper() {
        List<List<Boolean>> bigPaper = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List<Boolean> row = new ArrayList<>(Arrays.asList(new Boolean[100]));
            Collections.fill(row, false);
            bigPaper.add(row);
        }
        return bigPaper;
    }

    private void checkArea(List<List<Boolean>> bigPaper, List<Integer> location) {
        int startOfHeight = location.get(1);

        for (int j = 0; j < 10; j++) {
            int startOfWidth = location.get(0);

            List<Boolean> row = bigPaper.get(startOfHeight);
            checkElement(startOfWidth, row);
            checkRow(bigPaper, startOfHeight, row);
            startOfHeight += 1;
        }
    }

    private void checkElement(int startOfWidth, List<Boolean> row) {
        for (int k = 0; k < 10; k++) {
            row.set(startOfWidth, true);
            startOfWidth += 1;
        }
    }

    private void checkRow(List<List<Boolean>> bigPaper, int startOfHeight, List<Boolean> row) {
        bigPaper.set(startOfHeight, row);
    }

    private int measureAreaOfColoredPaper(List<List<Boolean>> bigPaper) {
        int area = 0;
        for (List<Boolean> booleans : bigPaper) {
            area += Collections.frequency(booleans, true);
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        int area = main.measureArea();
        System.out.println(area);
    }
}
