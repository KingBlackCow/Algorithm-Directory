package Eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2312_수복원하기 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            getPrimes(n);
            for (int i = 2; i <= n; i++) {
                if (!prime[i]) {
                    int cnt = 0;
                    while (n % i == 0) {
                        n /= i;
                        cnt++;
                    }
                    if(cnt == 0)continue;
                    sb.append(i + " " + cnt + "\n");
                }
            }
        }

        System.out.print(sb.toString());
    }

    private static void getPrimes(int n) {
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= n; j = j + i) {
                    prime[j] = true;
                }
            }
        }
    }
}