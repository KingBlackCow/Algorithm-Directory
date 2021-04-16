package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ20925_메이플스토리 {

    static int n, t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        int[][] dp=new int[1001][201];
        int[] c=new int[201];
        int[] experience =new int[201];
        int[][] time =new int[1001][1001];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            c[i]=Integer.parseInt(st.nextToken());
            experience[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                time[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] >= c[j]) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + experience[j]);
                }
                for (int k = 0; k < n; k++) {
                    if (i + time[j][k] <= t && dp[i][j] >= c[k]) {
                        dp[i + time[j][k]][k] = Math.max(dp[i + time[j][k]][k], dp[i][j]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, dp[t][i]);
        System.out.println(ans);

    }
}