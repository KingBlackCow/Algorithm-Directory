package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18290_nm과k {
    static int n, m, k;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][m];
        dfs(0, 0, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int cnt, int sum) {
        if (cnt == k) {
            max = Math.max(max, sum);
            return;
        }
        if (y >= m) {
            x++;
            y = 0;
        }
        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean flag = true;
                out:
                for (int l = 0; l < 4; l++) {
                    int r = i + dr[l];
                    int c = j + dc[l];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (visit[r][c]) {
                        flag = false;
                        break out;
                    }
                }
                if (flag && !visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j+1, cnt + 1, sum + map[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }
}

