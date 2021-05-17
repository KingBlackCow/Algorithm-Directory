package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ21736_헌내기는친구가필요해 {
    static int n, m;
    static List<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sx, sy;
    static char[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
                if (map[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }
        int tmp = bfs();
        String res = tmp == 0 ? "TT" : String.valueOf(tmp);
        System.out.println(res);
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sx, sy));
        visit = new boolean[n][m];
        visit[sx][sy] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = point.x + dr[i];
                int c = point.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (!visit[r][c] && map[r][c] == 'O') {
                    q.add(new Point(r, c));
                    visit[r][c] = true;
                } else if (!visit[r][c] && map[r][c] == 'P') {
                    q.add(new Point(r, c));
                    visit[r][c] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
