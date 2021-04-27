package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251_LCS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1= br.readLine();
        String str2= br.readLine();
        int n= Math.max(str1.length(),str2.length());
        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if(str2.charAt(i)!=str1.charAt(j)){
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }else{
                    dp[i+1][j+1]=dp[i][j]+1;
                }
            }
        }
        System.out.println(dp[str2.length()][str1.length()]);
    }
}