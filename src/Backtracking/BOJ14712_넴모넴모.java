package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ14712_넴모넴모 {
    static int n, m;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n + 1][m + 1];

        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int cnt) {
        if (cnt == n * m) {
            ans++;
            return;
        }

        int y = cnt / m + 1;
        int x = cnt % m + 1;
        if (map[y - 1][x] == 1 && map[y][x - 1] == 1 && map[y - 1][x - 1] == 1) {
            dfs(cnt + 1);
        } else {
            dfs(cnt + 1);
            map[y][x] = 1;
            dfs(cnt + 1);
            map[y][x] = 0;
        }
    }
}


