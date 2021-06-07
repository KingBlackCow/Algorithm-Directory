package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15988_123더하기3 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++) {
                dp[i] = (dp[i - 1]  + dp[i - 2]  + dp[i - 3]) % 1000000009;
            }
            sb.append(dp[n] + "\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}