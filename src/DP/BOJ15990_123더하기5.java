package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15990_123더하기5 {
    static int n;
    static long[][] dp;
    static int max = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        dp = new long[100001][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % max;
            dp[i][2] = (dp[i - 2][3] + dp[i - 2][1]) % max;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % max;
        }
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            long sum = (dp[n][1] + dp[n][2]  + dp[n][3]) % max;
            sb.append(sum + "\n");
        }

        System.out.println(sb.toString());
    }
}