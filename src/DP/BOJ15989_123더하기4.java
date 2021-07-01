package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15989_123더하기4 {
    static int n;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        dp = new long[10001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= 10000; i++) {
            dp[i] = dp[i - 3] + i / 2 + 1;
        }
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n] + "\n");
        }
        System.out.println(sb.toString());
    }


}