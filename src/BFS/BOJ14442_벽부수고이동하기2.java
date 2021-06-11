package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14442_벽부수고이동하기2 {
    static int n, m, k;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] ary;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[11][n][m];
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }
        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == n - 1 && tmp.y == m - 1) {
                System.out.println(tmp.cnt);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (tmp.first < k) {
                    if (ary[r][c] == 0 && !visit[tmp.first][r][c]) {
                        visit[tmp.first][r][c] = true;
                        q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                    }
                    if (ary[r][c] == 1 && !visit[tmp.first][r][c]) {
                        visit[tmp.first][r][c] = true;
                        q.add(new Node(r, c, tmp.cnt + 1, tmp.first + 1));
                    }

                } else {
                    if (!visit[tmp.first][r][c] && ary[r][c] == 0) {
                        visit[tmp.first][r][c] = true;
                        q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                    }
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