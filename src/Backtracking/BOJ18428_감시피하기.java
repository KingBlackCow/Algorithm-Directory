package Backtracking;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18428_감시피하기 {

    static int n, m;
    static char[][] ary;
    static char[][] arr;
    static List<Point> tList = new LinkedList<>();
    static List<Point> list = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int studentCnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ary = new char[n][n];
        arr = new char[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ary[i][j] = str[j].charAt(0);
                if (ary[i][j] == 'T') tList.add(new Point(i, j));
                else if (ary[i][j] == 'X') list.add(new Point(i, j));
                else if (ary[i][j] == 'S') studentCnt++;
            }
        }
        nCr(0, 0);
        System.out.println("NO");
    }

    private static void nCr(int x, int cnt) {
        if (x == 3) {
            aryCopy();
            check();
            if (check2()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for (int i = cnt; i < list.size(); i++) {
            Point p = list.get(i);
            ary[p.x][p.y] = 'B';
            nCr(x + 1, i + 1);
            ary[p.x][p.y] = 'X';
        }

    }

    private static boolean check2() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'S') {
                    sum++;
                }
            }
        }
        if (sum == studentCnt) return true;
        else return false;
    }

    private static void aryCopy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ary[i][j];
            }
        }
    }

    private static void check() {
        for (Point point : tList) {
            for (int i = 0; i < 4; i++) {
                int x = point.x;
                int y = point.y;
                while (true) {
                    x += dr[i];
                    y += dc[i];
                    if (x < 0 || y < 0 || x >= n || y >= n) break;
                    if (arr[x][y] == 'B') break;
                    arr[x][y] = 'T';
                }
            }
        }
    }

}