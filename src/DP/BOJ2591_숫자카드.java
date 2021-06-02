package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2591_숫자카드 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] ary = br.readLine().toCharArray();
        int len = ary.length;
        int[][] dp = new int[41][3];
        dp[1][1] = 1;
        int prev = (ary[0] - '0') * 10;
        for (int i = 2; i <= len; i++) {
            int cnt = ary[i - 1] - '0';
            if (cnt == 0) {
                if (prev + cnt <= 34) {
                    dp[i][2] = dp[i - 1][1];
                }
                continue;
            }
            if (prev + cnt <= 34) {
                dp[i][1] = dp[i - 1][2] + dp[i - 1][1];
                dp[i][2] = dp[i - 1][1];
            } else {
                dp[i][1] = dp[i - 1][2] + dp[i - 1][1];
            }
            prev = cnt * 10;
        }
        System.out.println(dp[len][1] + dp[len][2]);

    }
}
