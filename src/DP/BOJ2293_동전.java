package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293_동전 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, ans;
    private static int[] ary, dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ans = Integer.parseInt(st.nextToken());

        ary = new int[n + 1];
        dp = new int[ans + 1];
        dp[0] = 1;

        for(int i = 1 ; i <= n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            for (int j = ary[i]; j <= ans; j++)
                dp[j] += dp[j - ary[i]];
        }

        System.out.println(dp[ans]);
    }

}

