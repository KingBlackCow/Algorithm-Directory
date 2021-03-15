package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1535_안녕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int energy[] = new int[n];
        int happiness[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            energy[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happiness[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[100];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 99; j >= 0; j--) {
                int index = energy[i] + j;
                if (index < 100) {
                    dp[index] = Math.max(happiness[i] + dp[j], dp[index]);
                }
            }
        }
        for (int i = 0; i < 100; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }
}