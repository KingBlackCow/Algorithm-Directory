package Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16134_조합 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
      /*  int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {*/
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(nCr(n, r, 1000000007)).append('\n');
        //}
        System.out.println(sb);
    }


    private static long nCr(int n, int r, int p) {
        if (r == 0)
            return 1L;

        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % p;
        }
        return (fac[n] * power(fac[r], p - 2, p) % p * power(fac[n - r], p - 2, p) % p) % p;
    }

    private static long power(long x, int y, long p) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }
}