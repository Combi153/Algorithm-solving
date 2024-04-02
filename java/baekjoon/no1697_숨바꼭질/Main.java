package baekjoon.no1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class PointAndTime {
        int point;
        int time;

        public PointAndTime(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    static int bfs(int start, int end) {
        if (start == end) {
            return 0;
        }

        boolean[] visited = new boolean[100001];
        Queue<PointAndTime> queue = new LinkedList<>();
        queue.offer(new PointAndTime(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            PointAndTime pointAndTime = queue.poll();
            int lastPoint = pointAndTime.point;
            int time = pointAndTime.time;

            int walkingBack = lastPoint - 1;
            int walkingFront = lastPoint + 1;
            int teleport = lastPoint * 2;
            time++;

            if (walkingBack == end || walkingFront == end || teleport == end) {
                return time;
            } else {
                if (walkingBack <= 100000 && walkingBack >= 0 && !visited[walkingBack]) {
                    queue.add(new PointAndTime(walkingBack, time));
                    visited[walkingBack] = true;
                }
                if (walkingFront <= 100000 && walkingFront >= 0 && !visited[walkingFront]) {
                    queue.add(new PointAndTime(walkingFront, time));
                    visited[walkingFront] = true;
                }
                if (teleport <= 100000 && teleport >= 0 && !visited[teleport]) {
                    queue.add(new PointAndTime(teleport, time));
                    visited[teleport] = true;
                }
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int time = bfs(n, k);
        System.out.println(time);

    }
}
