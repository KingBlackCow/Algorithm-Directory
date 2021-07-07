package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS5567_결혼식 {
    static int n, m;
    static List<Integer> list[];
    static boolean[] visit;
    static int res = 0;
    static int[] depths;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        depths = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(s);
            list[s].add(f);
        }

        bfs(1, 0);
        for (int i = 1; i < depths.length; i++) {
            if (depths[i] > 0 && depths[i] <= 2) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static void bfs(int x, int depth) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        depths[x] = depth;
        int turn = 1;
        visit[x] = true;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                int cnt = q.poll();
                for (Integer i : list[cnt]) {
                    if (!visit[i]) {
                        visit[i] = true;
                        q.add(i);
                        depths[i] = turn;
                    }
                }
            }
            turn++;
        }

    }


}