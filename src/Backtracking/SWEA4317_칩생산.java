package Backtracking;

import java.util.Scanner;

class SWEA4317_칩생산 {
    static int n, m;
    static int[][] map;
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {

            n = sc.nextInt();
            m = sc.nextInt();
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            max = 0;
            dfs(0, 0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(int x, int y, int cnt) {
        if (x >= n - 1) {
            if (max < cnt) {
                max = cnt;
            }
            return;
        }

        if (map[x][y] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
            map[x][y] = 2;
            map[x][y + 1] = 2;
            map[x + 1][y] = 2;
            map[x + 1][y + 1] = 2;
            if (y + 2 < m - 1) {
                dfs(x, y + 2, cnt + 1);
            } else {
                dfs(x + 1, 0, cnt + 1);
            }
            map[x][y] = 0;
            map[x][y + 1] = 0;
            map[x + 1][y] = 0;
            map[x + 1][y + 1] = 0;
            if (y + 1 < m - 1) {
                dfs(x, y + 1, cnt);
            } else {
                dfs(x + 1, 0, cnt);
            }
        } else {
            if (map[x][y + 1] != 0 || map[x + 1][y + 1] != 0) {
                if (y + 2 < m - 1) {
                    dfs(x, y + 2, cnt);
                } else {
                    dfs(x + 1, 0, cnt);
                }
            } else {
                if (y + 1 < m - 1) {
                    dfs(x, y + 1, cnt);
                } else {
                    dfs(x + 1, 0, cnt);
                }
            }
        }
    }
}