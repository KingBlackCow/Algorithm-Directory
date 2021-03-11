package week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1080_행렬 {
    static int ans = 0;
    static int[][] ary;
    static int[][] ary2;
    static int n;
    static int m;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        ary2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary2[i][j] = Integer.parseInt(str[j]);
            }
        }


        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (ary[i][j] != ary2[i][j]) {
                    ans++;
                    change(i, j);
                }
            }
        }

        if (check()) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] != ary2[i][j]) return false;
            }
        }
        return true;
    }

    private static void change(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (i >= n || j >= m) continue;
                if (ary[i][j] == 0) {
                    ary[i][j] = 1;
                } else {
                    ary[i][j] = 0;
                }
            }
        }
    }


}
