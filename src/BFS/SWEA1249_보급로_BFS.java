package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1249_보급로_BFS {
    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] ary;
    static boolean[][][] visit;
    static int min ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            ary = new int[n][n];
            visit = new boolean[2000][n][n];
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split("");
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(str[j]);
                }
            }
            bfs();
            System.out.println("#"+t+" "+min);
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == n - 1 && tmp.y == n - 1) {
                min = Math.min(min, tmp.first);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;
                if (tmp.first > min) continue;
                if (ary[r][c] != 0 && !visit[tmp.first][r][c]) {
                    visit[tmp.first][r][c] = true;
                    q.add(new Node(r, c, tmp.cnt + 1, tmp.first+ary[r][c]));
                }
                if (ary[r][c] == 0 && !visit[tmp.first][r][c]) {
                    visit[tmp.first][r][c] = true;
                    q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                }

            }
        }

    }

    static class Node {
        int x;
        int y;
        int cnt;
        int first;

        Node(int x, int y, int cnt, int first) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.first = first;
        }
    }
}