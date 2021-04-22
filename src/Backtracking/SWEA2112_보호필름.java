package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2112_보호필름 {

    static int n, m, k, res, map[][];
    static int mapTmp[][];
    static boolean[] select;
    static List<Integer> list;
    static int tc;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            res = Integer.MAX_VALUE;
            map = new int[n][m];
            mapTmp = new int[n][m];
            select = new boolean[n];
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                powerShell(0, 0, i);
                if(res!=Integer.MAX_VALUE)break;
            }
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void powerShell(int x, int cnt,int end) {
        if (x == end) {
            list.clear();
            for (int i = 0; i < n; i++) {
                if (select[i]) {
                    list.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mapTmp[i][j] = map[i][j];
                }
            }
            if (colorShell(0)) {
                res = Math.min(list.size(), res);
            }
            return;
        }
        for (int i = cnt; i < n; i++) {
            if(res!=Integer.MAX_VALUE)break;
            select[i] = true;
            powerShell(x + 1, i+1,end);
            select[i] = false;
        }
    }

    private static boolean colorShell(int x) {
        if (x == list.size()) {
            if (check(mapTmp)) {
                return true;
            }
            return false;
        }
        changeOne(list.get(x));
        if (colorShell(x + 1)) return true;
        changeZero(list.get(x));
        if (colorShell(x + 1)) return true;
        return false;
    }

    private static void changeZero(int x) {
        for (int i = 0; i < m; i++) {
            mapTmp[x][i] = 0;
        }
    }

    private static void changeOne(int x) {
        for (int i = 0; i < m; i++) {
            mapTmp[x][i] = 1;
        }
    }

    private static boolean check(int[][] ary) {
        boolean flag = false;
        int checkRes = 0;
        if(k!=1) {
            for (int i = 0; i < m; i++) {
                int pivot = ary[0][i];
                int cnt = 1;
                flag = false;
                for (int j = 1; j < n; j++) {
                    if (pivot == ary[j][i]) {
                        cnt++;
                        if (cnt == k) {
                            flag = true;
                            break;
                        }
                    } else {
                        pivot = ary[j][i];
                        cnt = 1;
                    }
                }
                if (flag) {
                    checkRes++;
                }
            }
            if (checkRes == m) {
                return true;
            }
        }else{
            return true;
        }
        return false;
    }
}
