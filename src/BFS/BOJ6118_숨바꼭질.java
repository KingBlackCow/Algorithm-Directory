package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ6118_숨바꼭질 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int[] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> list[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visit = new int[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        bfs(1);
        int distance = 0;
        int node = 0;
        int same = 0;

        for (int i = 1; i <= n; i++) {
            if(visit[i]>distance){
                distance = visit[i];
                node = i;
                same = 1;
            }else if(visit[i]==distance){
                same++;
            }
        }
        distance--;
        System.out.println(node+" "+distance+" "+same);

    }

    private static void bfs(int start) {
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visit[start] = 1;
        while (!q.isEmpty()){
            int cnt = q.poll();
            for (Integer next: list[cnt]) {
                if(visit[next]==0){
                    visit[next] = visit[cnt]+1;
                    q.add(next);
                }
            }
        }
    }
}