package Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ17136_색종이붙이기 {

    static int[][] ary;
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ary = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        if (res == Integer.MAX_VALUE) {
            res = -1;
        }
        bw.write(res + "\n");
        bw.close();
        br.close();
    }

    private static void dfs(int x, int y, int cnt) {
        if (x > 9 || y > 9){
            res = Math.min(cnt, res);
            return;
        }

        if (cnt > res) return;
        if (ary[x][y] == 1) {
            for (int i = 5; i >= 1; i--) {
                if (colorPaper[i] > 0 && possible(x, y, i)) {
                    colorPaper[i]--;
                    color(x, y, i, 0);
                    if (y + 1 >= 10) {
                        dfs(x + 1, 0, cnt + 1);
                    } else {
                        dfs(x, y + 1, cnt + 1);
                    }
                    color(x, y, i, 1);
                    colorPaper[i]++;
                }
            }
        } else {
            if (y + 1 >= 10) {
                dfs(x + 1, 0, cnt);
            } else {
                dfs(x, y + 1, cnt);
            }
        }
    }

    private static void color(int x, int y, int size, int color) {
        if (color == 0) {
            for (int j = x; j < x + size; j++) {
                for (int k = y; k < y + size; k++) {
                    ary[j][k] = 0;
                }
            }
        } else {
            for (int j = x; j < x + size; j++) {
                for (int k = y; k < y + size; k++) {
                    ary[j][k] = 1;
                }
            }
        }

    }

    private static boolean possible(int x, int y, int size) {
        for (int j = x; j < x + size; j++) {
            for (int k = y; k < y + size; k++) {
                if (j > 9 || k > 9) return false;
                if (ary[j][k] == 0) return false;
            }
        }
        return true;
    }
}
