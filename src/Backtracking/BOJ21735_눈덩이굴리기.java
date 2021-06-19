package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21735_눈덩이굴리기 {

    public static int n, time;
    public static int[] ary;
    static int max = 0;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        ary = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        visit= new boolean[n+1];
        visit[1]=true;
        dfs(1, 0, 0);
        System.out.println(max);
    }

    private static void dfs(int x, int loc, int turn) {
        if (turn > time) return;
        if (loc == n || turn==time) {
            max = Math.max(max, x);
            return;
        }
        if (loc + 1 <= n) {
            visit[loc+1]=true;
            dfs(x + ary[loc + 1], loc + 1, turn + 1);
            visit[loc+1]=false;
        }
        if (loc + 2 <= n) {
            visit[loc+2]=true;
            dfs(x / 2 + ary[loc + 2], loc + 2, turn + 1);
            visit[loc+2]=false;
        }
    }
}