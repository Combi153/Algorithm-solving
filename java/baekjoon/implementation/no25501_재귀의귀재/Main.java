package implementation.no25501_재귀의귀재;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private final BufferedReader bufferedReader;
    private int count;

    public Main(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public void countNumberOfCall() throws IOException {
        int time = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < time; i++) {
            this.count = 0;
            String word = readWord();
            System.out.println(isPalindrome(word) + " " + count);
        }
    }

    public String readWord() throws IOException {
        return bufferedReader.readLine();
    }

    public int recursion(String s, int l, int r){
        this.count++;
        if(l >= r) {
            return 1;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        else {
            return recursion(s, l+1, r-1);
        }
    }

    public int isPalindrome(String s){
        this.count++;
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args){
        Main main = new Main(new BufferedReader(new InputStreamReader(System.in)));
        main.countNumberOfCall();
    }
}
