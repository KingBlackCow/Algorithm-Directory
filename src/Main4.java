import java.io.*;
import java.util.StringTokenizer;

class Main4 {
    static int n; // 가로(행)
    static int m; // 세로(렬)
    static int[][] ary; // 지도
    static int[][] dp; // 메모이제이션
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, - 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(String.valueOf(dfs(0, 0)));
        bw.flush();

    }

    private static int dfs(int x, int y) {

        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int r = x + dr[i];
                int c = y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if(ary[x][y]>ary[r][c]){
                    dp[x][y] += dfs(r, c);
                }
            }

        }
        return dp[x][y];

    }
}
