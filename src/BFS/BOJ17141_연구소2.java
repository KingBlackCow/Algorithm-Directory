package BFS;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ17141_연구소2 {
    static int n, m;
    static int[][] map;
    static List<Point> point = new ArrayList<>();
    static int[] ary;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MAX_VALUE;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        ary = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    point.add(new Point(i, j));
                }
            }
        }
        dfs(0, 0);
        max = max == Integer.MAX_VALUE ? -1 : max;
        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int cnt) {
        if (x == m) {
            q.clear();
            visit = new boolean[n][n];
            for (int i = 0; i < m; i++) {
                visit[point.get(ary[i]).x][point.get(ary[i]).y] = true;
                q.add(point.get(ary[i]));
            }
            int tmp = bfs();
            if (check())
                max = Math.min(max, tmp);
            return;
        }
        for (int i = cnt; i < point.size(); i++) {
            ary[x] = i;
            dfs(x + 1, i + 1);
        }
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int bfs() {
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = tmp.x + dr[j];
                    int c = tmp.y + dc[j];
                    if (r < 0 || c < 0 || r >= n || c >= n) continue;
                    if (!visit[r][c] && map[r][c] != 1) {
                        q.add(new Point(r, c));
                        visit[r][c] = true;
                    }
                }
            }
            turn++;
        }
        return turn - 1;
    }
}