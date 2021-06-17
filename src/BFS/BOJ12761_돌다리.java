package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12761_돌다리 {
    public static LinkedList<Integer>[] list;

    public static int[][] map;
    public static boolean[] visit;

    static int start, end, a, b;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));
        visit = new boolean[100001];
        visit[start] = true;
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == end) {
                System.out.println(point.y);
                System.exit(0);
            }
            if (point.x - 1 >= 0 && point.x - 1 <= 100000 && !visit[point.x - 1]) {
                visit[point.x - 1] = true;
                q.add(new Point(point.x - 1, point.y + 1));
            }
            if (point.x + 1 >= 0 && point.x + 1 <= 100000 && !visit[point.x + 1]) {
                visit[point.x + 1] = true;
                q.add(new Point(point.x + 1, point.y + 1));
            }
            if (point.x - a >= 0 && point.x - a <= 100000 && !visit[point.x - a]) {
                visit[point.x - a] = true;
                q.add(new Point(point.x - a, point.y + 1));
            }
            if (point.x + a >= 0 && point.x + a <= 100000 && !visit[point.x + a]) {
                visit[point.x + a] = true;
                q.add(new Point(point.x + a, point.y + 1));
            }
            if (point.x - b >= 0 && point.x - b <= 100000 && !visit[point.x - b]) {
                visit[point.x - b] = true;
                q.add(new Point(point.x - b, point.y + 1));
            }
            if (point.x + b >= 0 && point.x + b <= 100000 && !visit[point.x + b]) {
                visit[point.x + b] = true;
                q.add(new Point(point.x + b, point.y + 1));
            }
            if (point.x * a >= 0 && point.x * a <= 100000 && !visit[point.x * a]) {
                visit[point.x * a] = true;
                q.add(new Point(point.x * a, point.y + 1));
            }
            if (point.x * b >= 0 && point.x * b <= 100000 && !visit[point.x * b]) {
                visit[point.x * b] = true;
                q.add(new Point(point.x * b, point.y + 1));
            }


        }
    }
}