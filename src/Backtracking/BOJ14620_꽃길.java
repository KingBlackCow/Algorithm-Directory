package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14620_꽃길 {
    static int n;
    static int[][] map;
    static boolean[][] visit;
    static int min = 987654321;
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        res = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                visit = new boolean[n][n];
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(min);

    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == 3) {
            min = Math.min(min, sum);
            if (min > sum) {
                min = sum;
            }
            return;
        }
        if (y > n - 2) {
            x++;
            y = 1;
        }
        if (x > n - 2) {
            return;
        }
        boolean flag = true;
        for (int i = 0; i < 5; i++) {
            int r = x + dr[i];
            int c = y + dc[i];
            if (r < 0 || c < 0 || r >= n || c >= n) {
                flag = false;
                break;
            }
            if (visit[r][c]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            int tmp = 0;
            for (int i = 0; i < 5; i++) {
                int r = x + dr[i];
                int c = y + dc[i];
                visit[r][c] = true;
                tmp += map[r][c];
            }
            dfs(x, y + 1, cnt + 1, sum + tmp);
            for (int i = 0; i < 5; i++) {
                int r = x + dr[i];
                int c = y + dc[i];
                visit[r][c] = false;
            }
        }
        dfs(x, y + 1, cnt, sum);
    }
}