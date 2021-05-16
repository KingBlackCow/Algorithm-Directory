package 구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21610_마법사상어와비바라기 {
    static int n, m;
    static int[][] map;
    static Queue<Point> cloud = new LinkedList<>();
    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cloud.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        q.add(new Point(n - 2, 0));
        q.add(new Point(n - 2, 1));
        q.add(new Point(n - 1, 0));
        q.add(new Point(n - 1, 1));
        for (int i = 0; i < m; i++) {
            move();
            visit = new boolean[n][n];
            falling();
            make();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }

    private static void make() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !visit[i][j]) {
                    q.add(new Point(i, j));
                    map[i][j] -= 2;
                }
            }
        }
    }

    private static void falling() {
        while (!q.isEmpty()) {
            Point point = q.poll();
            int sum = 0;
            for (int j = 1; j <= 7; j += 2) {
                int r = point.x + dr[j];
                int c = point.y + dc[j];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;
                if (map[r][c] == 0) continue;
                sum++;
            }
            map[point.x][point.y] += sum;
            visit[point.x][point.y] = true;
        }
    }

    static void move() {
        Point cnt = cloud.poll();
        int dx = 0;
        int dy = 0;
        if (cnt.x != 3 || cnt.x != 7) {
            dx = cnt.y;
        }
        if (cnt.x != 1 || cnt.x != 5) {
            dy = cnt.y;
        }

        int qSize = q.size();
        for (int i = 0; i < qSize; i++) {
            Point point = q.poll();
            int r = point.x + dx * dr[cnt.x - 1];
            int c = point.y + dy * dc[cnt.x - 1];
            if (r < 0) {
                r = n - Math.abs(r) % n;
                if (r == n) r = 0;
            } else if (r >= n) {
                r %= n;
            }
            if (c < 0) {
                c = n - Math.abs(c) % n;
                if (c == n) c = 0;
            } else if (c >= n) {
                c %= n;
            }
            q.add(new Point(r, c));
            map[r][c] += 1;
        }
    }
}
