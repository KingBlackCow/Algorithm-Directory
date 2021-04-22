package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2115_벌꿀채취 {

    static int n, m, c, res, map[][], profit[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            profit = new int[n][n - m + 1];
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            res = 0;
            makeProfit();
            check();
            System.out.println("#" + tc + " " + res);
        }

    }

    private static void check() {
        int sum1 = 0, sum2 = 0 ,turn =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                sum1 = profit[i][j];
                int r = i;
                int c = j + m - 1;
                while (true){
                    c++;
                    if(c>n-m){
                        c=0;
                        r++;
                    }
                    if(r>=n)break;
                    sum2 = profit[r][c];
                    res=Math.max(res,sum1+sum2);
                }
            }
        }
    }

    private static void makeProfit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                powerShell(i, j, 0, 0, 0);
            }
        }
    }

    private static void powerShell(int x, int y, int turn, int sum, int total) {
        if (turn == m) {
            if (sum > c) return;
            profit[x][y - m] = Math.max(total, profit[x][y - m]);
            return;
        }

        powerShell(x, y + 1, turn + 1, sum + map[x][y], total + map[x][y] * map[x][y]);
        powerShell(x, y + 1, turn + 1, sum, total);
    }
}
