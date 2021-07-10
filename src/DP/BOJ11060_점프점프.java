package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11060_점프점프 {
    static int[] ary;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ary = new int[n];
        res = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(res,987654321);
        res[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= ary[i]; j++) {
                if (i + j < n) {
                    res[i + j] = Math.min(res[i + j], res[i] + 1);
                }
            }
        }
        if(res[n-1]==987654321){
            System.out.println(-1);
            System.exit(0);
        }
        sb.append(res[n - 1]);
        System.out.println(sb.toString());
    }


}