package DP;

import java.io.*;

public class BOJ2579_계단오르기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[301];
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[301];
        dp[1] = ary[1];
        dp[2] = ary[1] + ary[2];
        dp[3] = Math.max(ary[2] + ary[3], ary[1] + ary[3]);
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + ary[i], dp[i - 3] + ary[i - 1] + ary[i]);
        }
        bw.write(dp[n] + "\n");
        bw.close();
        br.close();
    }
}