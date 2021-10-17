package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9507_GenerationsOfTribbles {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] ary = new long[70];
        ary[0] = 1;
        ary[1] = 1;
        ary[2] = 2;
        ary[3] = 4;
        for (int i = 4; i < 70; i++) {
            ary[i] = ary[i-1]+ary[i-2]+ary[i-3]+ary[i-4];
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            int n = Integer.parseInt(br.readLine());
            sb.append(ary[n]+"\n");
        }
        System.out.println(sb.toString());

    }


}


