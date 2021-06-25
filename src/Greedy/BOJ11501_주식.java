package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11501_주식 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ary = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }
            int max = ary[n - 1];
            long sum = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (max > ary[i]) {
                    sum += max - ary[i];
                } else {
                    max = ary[i];
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }
}

