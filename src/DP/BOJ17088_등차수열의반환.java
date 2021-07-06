package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17088_등차수열의반환 {
    static int n;
    static int[] ary;
    static int[] dx = { -1, 1, 0};
    static int res=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ary = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        if (n <= 2) {
            System.out.println(0);
            System.exit(0);
        }

        dfs(ary[0] - 1, 0, 1,1);
        dfs(ary[0], 0, 1,0);
        dfs(ary[0] + 1, 0, 1,1);
        if(res==987654321){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }

    private static void dfs(int past, int diff, int turn,int sum) {
        if(turn>=n){
            res=Math.min(res,sum);
            return;
        }
        if (turn == 1) {
            int cnt = 0;
            for (int i = 0; i < 3; i++) {
                cnt = ary[turn] + dx[i];
                int cntDiff = cnt - past;
                if(i<2){
                    dfs(cnt, cntDiff, turn + 1,sum+1);
                }else{
                    dfs(cnt, cntDiff, turn + 1,sum);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int cnt =ary[turn]+dx[i];
                int cntDiff= cnt-past;
                if(cntDiff==diff){
                    if(i<2){
                        dfs(cnt,cntDiff,turn+1,sum+1);
                    }else{
                        dfs(cnt,cntDiff,turn+1,sum);
                    }
                }
            }
        }

    }
}