package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13565_침투 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    static boolean[][] visit;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> list[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < m; i++) {
            if (map[0][i] == '0') {
                boolean flag = bfs(0, i);
                if(flag){
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");

    }

    private static boolean bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        while (!q.isEmpty()) {
            Point cnt = q.poll();
            if(cnt.x==n-1){
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int r = cnt.x + dr[i];
                int c = cnt.y + dc[i];
                if(r<0||c<0||r>=n||c>=m)continue;
                if(map[r][c]=='0' &&!visit[r][c]){
                    q.add(new Point(r,c));
                    visit[r][c] = true;
                }
            }
        }
        return false;
    }
}