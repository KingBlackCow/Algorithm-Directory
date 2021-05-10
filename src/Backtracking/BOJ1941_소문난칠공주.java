package Backtracking;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1941_소문난칠공주 {
    static char[][] map = new char[5][5];
    static int[] select = new int[7];
    static int sNum = 0;
    static int yNum = 0;
    static boolean[][] visit;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        nCr(0, 0);
        System.out.println(res);
    }

    private static void nCr(int x, int cnt) {
        if (x == 7) {
            sNum = 0;
            yNum = 0;
            visit = new boolean[5][5];
            for (int i = 0; i < 7; i++) {
                int r = select[i] / 5;
                int c = select[i] % 5;
                if (map[r][c] == 'S') {
                    sNum++;
                } else {
                    yNum++;
                }
                visit[r][c] = true;
            }
            if (sNum >= 4) {
                if (bfs() == 7) {
                    res++;
                }
            }
            return;
        }
        for (int i = cnt; i < 25; i++) {
            select[x] = i;
            nCr(x + 1, i + 1);
        }
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(select[0] / 5, select[0] % 5));
        visited = new boolean[5][5];
        visited[select[0] / 5][select[0] % 5] = true;
        int len = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();
            len++;
            for (int i = 0; i < 4; i++) {
                int r = point.x + dr[i];
                int c = point.y + dc[i];
                if (r < 0 || c < 0 || r >= 5 || c >= 5) continue;
                if (visit[r][c] && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                }
            }
        }
        return len;
    }

}
