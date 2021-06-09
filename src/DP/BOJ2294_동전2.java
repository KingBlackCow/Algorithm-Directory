package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2294_동전2 {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] coin = new int[100001];

        int[] dp = new int[100001];
        for (int i = 1; i < 100001; i++) {
            dp[i] = 100001;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
            dp[coin[i]] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if (dp[m] == 100001) System.out.println(-1);
        else System.out.println(dp[m]);
    }
}