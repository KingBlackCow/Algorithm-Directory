package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1189_컴백홈 {
    static int n, m, k;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int ans = 0;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visit[n - 1][0] = true;
        dfs(n - 1, 0,1);
        System.out.println(ans);
    }

    private static void dfs(int x, int y,int turn) {
        if (x == 0 && y == m - 1 && turn ==k) {
            ans++;
        }
        for (int i = 0; i < 4; i++) {
            int r = x + dr[i];
            int c = y + dc[i];
            if (r < 0 || c < 0 || r >= n || c >= m) continue;
            if(visit[r][c]||map[r][c]=='T')continue;
            visit[r][c] = true;
            dfs(r, c,turn+1);
            visit[r][c] = false;

        }
    }
}