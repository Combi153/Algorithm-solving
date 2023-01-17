package date1004_implementation.no11721_끊어출력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final double CUTTING_SIZE = 10;
    private final BufferedReader bufferedReader;

    public Main(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void printCutWords() throws IOException {
        String line = readOneLine();
        int count = getCuttingCount(line);

        for (int i = 0; i < count; i++) {
            int startIndex = i * 10;
            int endIndex = startIndex + 10;

            if (i == count - 1) {
                String cutWord = line.substring(startIndex);
                System.out.println(cutWord);
                return;
            }
            String cutWord = line.substring(startIndex, endIndex);
            System.out.println(cutWord);
        }
    }

    private int getCuttingCount(String line) {
        return (int) Math.ceil(line.length() / CUTTING_SIZE);
    }

    private String readOneLine() throws IOException {
        return bufferedReader.readLine();
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        main.printCutWords();
    }
}
