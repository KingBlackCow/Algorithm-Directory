package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9944_NxM보드완주하기 {
    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int dot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int turn = 1;
        String input = null;

        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            if (!st.hasMoreTokens()) {
                break;
            }
            dot = 0;
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        dot++;
                    }
                }
            }
            visit = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == '.') {
                        visit[i][j] = true;
                        dfs(i, j, 0, 1);
                        visit[i][j] = false;
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                sb.append("Case " + turn + ": " + -1 + "\n");

            } else {
                sb.append("Case " + turn + ": " + min + "\n");
            }
            turn++;
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (sum == dot) {
            min = Math.min(cnt, min);
        }
        for (int i = 0; i < 4; i++) {
            int k = 1;
            int r;
            int c;

            boolean flag = false;
            int dotNum = 0;
            while (true) {
                r = x + k * dr[i];
                c = y + k * dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) break;
                if (!visit[r][c] && map[r][c] == '.') {
                    visit[r][c] = true;
                } else {
                    break;
                }
                k++;
                flag = true;
                dotNum++;
            }
            if (flag) {
                --k;
                r = x + k * dr[i];
                c = y + k * dc[i];
                dfs(r, c, cnt + 1, sum + dotNum);
                while (k > 0) {
                    r = x + k * dr[i];
                    c = y + k * dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) break;
                    if (visit[r][c] && map[r][c] == '.') {
                        visit[r][c] = false;
                    } else {
                        break;
                    }
                    k--;

                }
            }
        }

    }

}