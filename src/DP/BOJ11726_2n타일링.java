package DP;

import java.io.*;

public class BOJ11726_2n타일링 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int j = 3; j <= n; j++) {
            dp[j] = dp[j - 1] % 10007 + dp[j - 2] % 10007;
        }
        bw.write(dp[n] % 10007 + "\n");
        bw.close();
        br.close();
    }
}