package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BOJ17070_파이프옮기기 {
    static int[][] ary;
    static boolean visit[][];
    static int n, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ary = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        dfs(0, 1, 1);
        System.out.println(res);
    }

    private static void dfs(int x, int y, int cnt) {
        if (x == n - 1 && y == n - 1) {
            res++;
            return;
        } else if (y > n - 1) {
            return;
        } else if (x > n - 1) {
            return;
        }
        if (y + 1 <= n - 1 && ary[x][y + 1] == 0 && cnt == 1) {
            dfs(x, y + 1, 1);
        }
        if (x + 1 <= n - 1 && y + 1 <= n - 1 && ary[x][y + 1] == 0 && ary[x + 1][y + 1] == 0 && ary[x + 1][y] == 0 && cnt == 1) {
            dfs(x + 1, y + 1, 3);
        }
        if (x + 1 <= n - 1 && cnt == 2 && ary[x + 1][y] == 0) {
            dfs(x + 1, y, 2);
        }
        if (y + 1 <= n - 1 && x + 1 <= n - 1 && ary[x][y + 1] == 0 && ary[x + 1][y + 1] == 0 && ary[x + 1][y] == 0 && cnt == 2) {
            dfs(x + 1, y + 1, 3);
        }
        if (y + 1 <= n - 1 && cnt == 3 && ary[x][y + 1] == 0) {
            dfs(x, y + 1, 1);
        }
        if (x + 1 <= n - 1 && cnt == 3 && ary[x + 1][y] == 0) {
            dfs(x + 1, y, 2);
        }
        if (y + 1 <= n - 1 && x + 1 <= n - 1 && ary[x][y + 1] == 0 && ary[x + 1][y + 1] == 0 && ary[x + 1][y] == 0 && cnt == 3) {
            dfs(x + 1, y + 1, 3);
        }
    }
}

