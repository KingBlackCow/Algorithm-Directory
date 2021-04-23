package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {
    static int n, m, k;
    static int[][] map;
    static int[][] tmp;
    static int min;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;


            backtracking(0, 0);
            sb.append("#" + tc + " " + min + "\n");



        }
        System.out.println(sb.toString());
    }

    private static void backtracking(int x, int cnt) {
        if (x == n) {
            if (check(tmp)) {
                min = Math.min(cnt, min);
            }
            return;
        }
        if(cnt> min)return;
        for (int i = 0; i < m; i++) {
            tmp[x][i] = map[x][i];
        }
        backtracking(x + 1, cnt);

        Arrays.fill(tmp[x], 1);
        backtracking(x + 1, cnt + 1);

        Arrays.fill(tmp[x], 0);
        backtracking(x + 1, cnt + 1);

    }

    private static boolean check(int[][] map) {
        for (int i = 0; i < m; i++) {
            int pivot = map[0][i];
            int cnt = 1;
            boolean flag = false;
            for (int j = 1; j < n; j++) {
                if (pivot == map[j][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                    pivot = map[j][i];
                }
                if (cnt == k) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}