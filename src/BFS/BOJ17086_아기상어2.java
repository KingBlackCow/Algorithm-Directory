package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17086_아기상어2 {
    static int n, m;
    static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] ary;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str[] = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(str[j]);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit = new boolean[n][m];
                if (ary[i][j] == 0) {
                    max = Math.max(bfs(i, j), max);

                }
            }

        }
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visit[x][y] = true;
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node tmp = q.poll();
                if (ary[tmp.x][tmp.y] == 1) {
                    return turn;
                }
                for (int j = 0; j < 8; j++) {
                    int r = tmp.x + dr[j];
                    int c = tmp.y + dc[j];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (!visit[r][c]) {
                        visit[r][c] = true;
                        q.add(new Node(r, c));
                    }
                }
            }
            turn++;

        }
        return 0;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}