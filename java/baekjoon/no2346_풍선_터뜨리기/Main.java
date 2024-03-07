package baekjoon.no2346_풍선_터뜨리기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();

        for (int i = 1; i <= cnt; i++) {
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < cnt; i++) {
            Balloon balloon = balloons.pollFirst();
            bw.write(Objects.requireNonNull(balloon).order() + " ");
            int value = balloon.value();

            if (balloons.size() == 1) {
                bw.write(String.valueOf(balloons.pollFirst().order()));
                break;
            }

            if (value > 0) {
                for (int j = 1; j < value; j++) {
                    balloons.addLast(balloons.pollFirst());
                }
            } else {
                for (int j = 0; j < Math.abs(value); j++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Balloon {
    private final int order;
    private final int value;

    public Balloon(int order, int value) {
        this.order = order;
        this.value = value;
    }

    public int order() {
        return order;
    }

    public int value() {
        return value;
    }
}
