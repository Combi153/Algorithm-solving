package baekjoon.no11286_절댓값_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Abs implements Comparable<Abs> {
        private final int value;

        public Abs(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Abs other) {
            if (Math.abs(this.value) > Math.abs(other.value)) {
                return 1;
            } else if (Math.abs(this.value) < Math.abs(other.value)) {
                return -1;
            } else {
                if (this.value > other.value) {
                    return 1;
                }
                if (this.value < other.value) {
                    return -1;
                }
                return 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Abs> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            Abs absX = new Abs(x);

            if (x == 0 && pq.isEmpty()) {
                System.out.println(0);
            } else if (x == 0) {
                System.out.println(pq.poll().value);
            } else {
                pq.add(absX);
            }
        }
    }
}
