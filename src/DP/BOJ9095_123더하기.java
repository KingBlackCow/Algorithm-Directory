package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9095_123더하기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;

            for (int j = 4; j <= n; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            bw.write(dp[n] + "\n");
        }

        bw.close();
        br.close();
    }
}