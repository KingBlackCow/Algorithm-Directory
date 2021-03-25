package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고싶은원숭이 {
    static int k, n, m;
    static int[] dr = {-1, 1, 0, 0, -2, -2, 2, 2, 1, -1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1, 2, 2, -2, -2};
    static int[][] ary;
    static boolean[][][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[k + 1][n][m];
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, k));
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == n - 1 && tmp.y == m - 1) {
                System.out.println(tmp.cnt);
                System.exit(0);
            }

            for (int i = 0; i < 12; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (i < 4) {
                    if(ary[r][c]==0&&!visit[tmp.first][r][c]){
                        visit[tmp.first][r][c]=true;
                        q.add(new Node(r, c, tmp.cnt + 1, tmp.first));
                    }

                } else {
                    if (tmp.first > 0) {
                        if(ary[r][c]==0&&!visit[tmp.first-1][r][c]) {
                            visit[tmp.first-1][r][c] = true;
                            q.add(new Node(r, c, tmp.cnt + 1, tmp.first - 1));
                        }
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