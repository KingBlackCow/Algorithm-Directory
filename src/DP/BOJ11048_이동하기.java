package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ11048_이동하기 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dr={0,-1,-1};
    static int[] dc={-1,0,-1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = ary[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int max=0;
                for (int k = 0; k < 3; k++) {
                    if(i+dr[k]<0||j+dc[k]<0||i+dr[k]>=n||j+dc[k]>=m)continue;
                    max=Math.max(dp[i+dr[k]][j+dc[k]],max);
                }
                dp[i][j]=max+ary[i][j];
            }
        }
        bw.write(dp[n-1][m-1] + "\n");
        bw.close();
        br.close();
    }
}