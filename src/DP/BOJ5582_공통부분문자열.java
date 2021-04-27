package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ5582_공통부분문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "a"+br.readLine();
        String str2 = "b"+br.readLine();
        int max = 0;
        int[][] dp = new int[str2.length()+1][str1.length()+1];
        for (int i = 1; i < str2.length(); i++) {
            for (int j = 1; j < str1.length(); j++) {
                if (str2.charAt(i) != str1.charAt(j)) {
                    dp[i][j]= 0;
                } else {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        System.out.println(max);
    }
}