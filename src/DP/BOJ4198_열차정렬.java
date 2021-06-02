package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4198_열차정렬 {

    static int n;
    static int[] ary;
    static int lis[];
    static int lds[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        lis = new int[n];
        lds = new int[n];

        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (ary[j] > ary[i]) lis[i] = Math.max(lis[j], lis[i]);
                else lds[i] = Math.max(lds[j], lds[i]);
            }
            lds[i]++;
            lis[i]++;
            max = Math.max(max, lds[i] + lis[i] - 1);
        }

        System.out.println(max);
    }
}