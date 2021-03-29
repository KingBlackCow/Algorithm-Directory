package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2629_양팔저울 {
    static int N;
    static boolean[][] visit;
    static List<Integer> choo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        choo = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            choo.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        List<Integer> balls = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            balls.add(Integer.parseInt(st.nextToken()));
        }

        visit = new boolean[N + 1][40001];

        dfs(0, 0);

        for (Integer i : balls) {
            if (visit[N][i]) {
                System.out.print("Y ");
                continue;
            } else {
                System.out.print("N ");

            }
        }
    }

    public static void dfs(int x, int cnt) {
        if (x > 40000 || x < 0) return;
        if (visit[cnt][x]) return;
        visit[cnt][x] = true;
        if (cnt == N) return;

        dfs(x + choo.get(cnt),cnt + 1);
        dfs(x,cnt + 1);
        dfs(Math.abs(x - choo.get(cnt)),cnt + 1);
    }
}