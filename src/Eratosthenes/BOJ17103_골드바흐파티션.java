package Eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17103_골드바흐파티션 {
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        getPrimes(1000000);
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 2; i <= n/2; i++) {
                if (!prime[i]&&!prime[n-i]) {
                    cnt++;
                }
            }
            sb.append(cnt +"\n");
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