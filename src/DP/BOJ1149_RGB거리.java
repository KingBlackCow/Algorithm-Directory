package DP;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149_RGB거리 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] color=new int[n][3];
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int min=Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if(j==k)continue;
                    min=Math.min(min,color[i-1][k]);
                }
                color[i][j]+=min;
            }
        }
        int min =Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min=Math.min(color[n-1][i],min);
        }
        bw.write(min+"\n");
        bw.close();
        br.close();
    }
}