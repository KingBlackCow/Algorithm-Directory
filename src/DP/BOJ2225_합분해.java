package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2225_합분해 {
    static int n, k;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[201][201];
        for (int i = 1; i <= k; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j]=(dp[i][j-1]+dp[i-1][j])%1000000000;
            }
        }
        System.out.println(dp[k][n]);

    }
}
