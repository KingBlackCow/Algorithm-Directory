package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1699_제곱수의합 {
    static int n;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[100001];
        Arrays.fill(dp,100);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int cnt = 4;

        while (cnt<=n) {
            int k = 1;
            while (true) {
                int tmp = (int) Math.pow(k, 2);
                if (cnt - tmp < 0) break;
                dp[cnt] = Math.min(dp[cnt], dp[cnt - tmp] + 1);
                k++;
            }
            cnt++;
        }
        System.out.println(dp[n]);
    }
}
