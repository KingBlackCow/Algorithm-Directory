package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2193_이친수 {
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long dp[] = new long[91];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
        bw.flush();
        bw.close();
        br.close();
    }
}
