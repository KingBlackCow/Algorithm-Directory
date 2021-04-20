package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17391_무한부스터 {
    static int n, m;
    static int[][] ary;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1, 0));
        visit[1][1] = true;
        while (!q.isEmpty()) {
            Point point = q.poll();
            if (point.x == n && point.y == m) {
                System.out.println(point.cnt);
                System.exit(0);
            }
            for (int i = 0; i < 2; i++) {
                for (int weight = 1; weight <= ary[point.x][point.y]; weight++) {
                    int r = point.x + weight * dr[i];
                    int c = point.y + weight * dc[i];
                    if (r < 1 || c < 1 || r > n || c > m) continue;
                    if (!visit[r][c]) {
                        q.add(new Point(r, c, point.cnt + 1));
                        visit[r][c] = true;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
