package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18405_경쟁적전염 {
    static int n, k;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int turn = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
        out:
        for (int b = 0; b < turn; b++) {
            for (int a = 1; a <= k; a++) {
                visit = new boolean[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == a && !visit[i][j]) {
                            bfs(i, j);
                            if (map[x][y] != 0) break out;
                        }
                    }
                }
            }
        }
        System.out.println(map[x][y]);
    }

    private static void bfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + dr[i];
            int c = y + dc[i];
            if (r < 0 || c < 0 || r >= n || c >= n) continue;
            if (map[r][c] != 0 && !visit[r][c]) continue;
            map[r][c] = map[x][y];
            visit[r][c] = true;
        }
    }
}