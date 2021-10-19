package Backtracking;

import java.util.Scanner;

class SWEA모의_장기포게임 {
    static int n;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sx, sy;
    static int ans = 0;
    static boolean[][] visit;
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            map = new int[n][n];
            visit = new boolean[n][n];
            ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                    if (map[i][j] == 2) {
                        sx = i;
                        sy = j;
                        map[i][j] = 0;
                    }
                }
            }

            dfs(sx, sy,0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visit[i][j]){
                        ans++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }

        sc.close();
    }

    private static void dfs(int x, int y, int turn) {
        if(turn>=3){
            return;
        }
        for (int i = 0; i < 4; i++) {
            int s = 1;
            int flag = 0;
            while (true) {
                if (flag >= 2) break;
                int r = x + s * dr[i];
                int c = y + s * dc[i];
                s++;
                if(r<0||c<0||r>=n||c>=n)break;
                if (flag == 0 && map[r][c] == 1) {
                    flag++;
                    continue;
                }
                if (flag == 1) {
                    if(map[r][c]==1){
                        map[r][c] = 0;
                        visit[r][c] = true;
                        flag++;
                        dfs(r, c, turn+1);
                        map[r][c] =1;
                    }else{
                        dfs(r, c, turn+1);
                    }
                }
            }
        }
    }
}
