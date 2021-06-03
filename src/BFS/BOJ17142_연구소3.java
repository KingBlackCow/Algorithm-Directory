package BFS;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ17142_연구소3 {
    static int n, m;
    static int[][] map;
    static List<Point> point = new ArrayList<>();
    static int[] ary;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MAX_VALUE;
    static boolean[][] visit;
    static int count = 0, answer = Integer.MAX_VALUE;

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
                if (map[i][j] == 0) count++;
            }
        }
        if (count != 0) dfs(0, 0);
        else answer = 0;

        bw.write((answer == Integer.MAX_VALUE ? -1 : answer) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int cnt) {
        if (x == m) {
            q.clear();
            visit = new boolean[n][n];
            int[][] map2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map2[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                visit[point.get(ary[i]).x][point.get(ary[i]).y] = true;
                q.add(point.get(ary[i]));
            }


            for (int i = 0; i < point.size(); i++) {
                if (!visit[point.get(i).x][point.get(i).y])
                    map2[point.get(i).x][point.get(i).y] = 3;
            }
            bfs(map2, count);

            //max = Math.min(max, check(tmp));
            return;
        }
        for (int i = cnt; i < point.size(); i++) {
            ary[x] = i;
            dfs(x + 1, i + 1);
        }
    }

    private static int check(int[][] map2) {
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map2[i][j]);
            }
        }
        return max;
    }

    private static void bfs(int[][] map, int count) {
        int turn = 0;
        while (!q.isEmpty()) {
            if (answer <= turn) break;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Point tmp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int r = tmp.x + dr[j];
                    int c = tmp.y + dc[j];
                    if (r < 0 || c < 0 || r >= n || c >= n) continue;
                    if (map[r][c] == 1 || map[r][c] == 2) continue;
                    if (map[r][c] == 0) count--;
                    q.add(new Point(r, c));
                    map[r][c] = 2;
                }
            }
            turn++;

            if (count == 0) {
                answer = turn;
                return;
            }
        }
    }
}