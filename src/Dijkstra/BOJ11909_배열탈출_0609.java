package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ11909_배열탈출_0609 {

    static int n;
    static int[][] ary;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        ary = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) {
                    break;
                }
                if (i != n - 1) {
                    int diff = ary[i + 1][j] - ary[i][j] + 1;
                    if(diff>0){
                        dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+diff);
                    }else{
                        dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]);
                    }
                }
                if (j != n - 1) {
                    int diff = ary[i][j+1] - ary[i][j] + 1;
                    if(diff>0){
                        dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+diff);
                    }else{
                        dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]);
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}