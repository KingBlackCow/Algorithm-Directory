package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7570_줄세우기 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int[] ary = new int[N];
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp=Integer.parseInt(st.nextToken());
            ary[i] = tmp;
            dp[tmp]=dp[tmp-1]+1;
        }
        Arrays.sort(dp);

        System.out.println(N - dp[N]);
    }
}
