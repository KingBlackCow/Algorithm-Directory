package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2239_스도쿠 {
    static int[][] ary = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                ary[i][j] = str[j] - '0';
            }
        }
        dfs(0, 0);
    }

    private static void dfs(int x, int y) {
        if (y >= 9) {
            y = 0;
            x++;
        }
        if (x >= 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(ary[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        if (ary[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                if (garoCheck(x, i) && seroCheck(y, i) && wholeCheck(x, y, i)) {
                    ary[x][y] = i;
                    dfs(x, y + 1);
                    ary[x][y] = 0;
                }
            }
        } else {
            dfs(x, y + 1);
        }

    }

    private static boolean wholeCheck(int x, int y, int tmp) {
        int nx = x / 3;
        int ny = y / 3;
        for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 9; k++) {
                if (nx == j / 3 && ny == k / 3) {
                    if (ary[j][k] == tmp) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static boolean garoCheck(int x, int tmp) {
        for (int i = 0; i < 9; i++) {
            if (ary[x][i] == tmp) {
                return false;
            }
        }
        return true;
    }

    private static boolean seroCheck(int y, int tmp) {
        for (int i = 0; i < 9; i++) {
            if (ary[i][y] == tmp) {
                return false;
            }
        }
        return true;
    }
}

