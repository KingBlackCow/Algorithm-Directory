package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2117_홈방범서비스 {

    static int n, m;
    static int[][] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ary = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int k = 1; k <= n + 1; k++) {
                max = Math.max(max, calc(k));
            }
            sb.append("#" + tc + " " + max + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int calc(int k) {
        int maxHomeCount = 0;
        int price = k * k + (k - 1) * (k - 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int homeCount = 0;
                for (int r = i - (k - 1); r <= i + (k - 1); r++) {
                    for (int c = j - (k - 1); c <= j + (k - 1); c++) {
                        if (r < 0 || c < 0 || r >= n || c >= n) continue;
                        if (Math.abs(r - i) + Math.abs(c - j) >= k) continue;
                        if (ary[r][c] == 1) {
                            homeCount++;
                        }
                    }
                }
                int profit = homeCount * m - price;
                if (profit >= 0) {
                    maxHomeCount = Math.max(maxHomeCount, homeCount);
                }
            }
        }
        return maxHomeCount;
    }
}
