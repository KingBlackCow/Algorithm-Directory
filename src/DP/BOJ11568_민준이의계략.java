package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11568_민준이의계략 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[] ary = new int[N];
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int max = 0;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (ary[i] > ary[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
