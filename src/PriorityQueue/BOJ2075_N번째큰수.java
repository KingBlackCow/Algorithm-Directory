package PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2075_N번째큰수 {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(new Point(map[n - 1][i], n - 1, i));
        }
        int turn = n;
        int res = 0;
        while (turn-- > 0) {
            Point point = pq.poll();
            int x = point.x - 1;
            res = point.cnt;
            if (x < 0) continue;
            pq.add(new Point(map[x][point.y], x, point.y));
        }
        System.out.println(res);
    }

    static class Point implements Comparable<Point> {
        int cnt;
        int x;
        int y;

        public Point(int cnt, int x, int y) {
            this.cnt = cnt;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }
}