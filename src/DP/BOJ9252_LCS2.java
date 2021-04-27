package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9252_LCS2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int n = Math.max(str1.length(), str2.length());
        int[][] dp = new int[n + 1][n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 0; j < str1.length(); j++) {
                if (str2.charAt(i) != str1.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                } else {
                    dp[i + 1][j + 1] = dp[i][j] + 1;

                }
            }
        }
        int r = str2.length();
        int c = str1.length();
        Stack<Character> stack =new Stack<>();
        while (true) {
            if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else if (dp[r][c] == dp[r][c - 1]) {
                c--;
            } else {
                stack.add(str1.charAt(c-1));
                r--;
                c--;
            }
            if (r <= 0 || c <= 0) break;
        }
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(dp[str2.length()][str1.length()]);
        System.out.println(sb.toString());
    }
}