package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716_현수막 {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 8; i++) {
                int r = p.x + dr[i];
                int c = p.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (!visit[r][c] && map[r][c] == 1) {
                    visit[r][c] = true;
                    q.add(new Point(r, c));
                }
            }
        }
    }
}


