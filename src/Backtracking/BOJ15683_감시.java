package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15683_감시 {

    static int N, M, res, cctvNum;
    static CCTV[] cctvs;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    static int[][][] ccDir = {
            {{0}},
            {{1}, {2}, {3}, {0}},
            {{1, 3}, {0, 2}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
            {{0, 1, 2, 3}},
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        cctvs = new CCTV[8];

        int remain = N * M;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs[cctvNum++] = new CCTV(map[i][j], i, j);
                }
                else if(map[i][j] == 6) remain--;
            }
        }
        res = Integer.MAX_VALUE;
        process(0, remain - cctvNum, map);
        System.out.println(res);
    }

    private static void process(int idx, int remain, int[][] map) {

        if(idx == cctvNum) {
            res = Math.min(res, remain);
            return;
        }

        int[][] newMap = new int[N][M];
        copy(newMap, map);

        CCTV cctv = cctvs[idx];

        for (int j = 0; j < ccDir[cctv.type].length; j++) {
            int check = 0;
            for (int k = 0; k < ccDir[cctv.type][j].length; k++) {
                int dir = ccDir[cctv.type][j][k];
                check += observation(cctv.r, cctv.c, dir, newMap);
            }

            process(idx + 1, remain - check, newMap);
            copy(newMap, map);
        }

    }

    private static int observation(int r, int c, int d, int[][] map) {
        int cnt = 0;

        while(true) {
            r += dr[d];
            c += dc[d];
            if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] == 6) return cnt;
            if((map[r][c] >= 1 && map[r][c] <= 5) || map[r][c] == -1) continue;
            map[r][c] = -1;
            cnt++;
        }

    }

    private static void copy(int[][] newMap, int[][] map) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }

    }

    static class CCTV {
        int type, r, c;

        public CCTV(int type, int r, int c) {
            this.type = type;
            this.r = r;
            this.c = c;
        }

    }

}