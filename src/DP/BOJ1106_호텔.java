package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106_호텔 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int wholePerson = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());
        int[] dp = new int[1501];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            for (int j = 0; j <= 1500; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;
                for (int k = 1; j + person * k <= 1500; k++)
                    dp[j + person * k] = Math.min(dp[j + person * k], dp[j] + price * k);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = wholePerson; i <= 1500; i++) {
            ans = Math.min(ans, dp[i]);
        }
        bw.write(ans + "");
        bw.close();
    }
}