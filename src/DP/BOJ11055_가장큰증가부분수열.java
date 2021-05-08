package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055_가장큰증가부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[n];
        int[] sum = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        max=sum[0] = ary[0];
        for (int i = 1; i < n; i++) {
            int pivot = i - 1;
            while (pivot >= 0) {
                if (ary[pivot] < ary[i]) {
                    sum[i] = Math.max(sum[i], sum[pivot] + ary[i]);
                }
                pivot--;
            }
            if (sum[i] == 0) {
                sum[i] += ary[i];
            }
            max = Math.max(max, sum[i]);
        }
        System.out.println(max);
    }
}