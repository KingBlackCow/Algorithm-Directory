package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ7576_토마토 {

    static int n, m;
    static int[][] ary;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if (ary[i][j] == 1) {
                    list.add(new Node(i, j));
                }
            }
        }
        int res = bfs();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] == 0) {
                    flag = false;
                }
            }
        }
        if (flag) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        for (Node node : list) {
            visit[node.x][node.y] = true;
            q.add(new Node(node.x, node.y));
        }

        int turn = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Node tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int r = tmp.x + dx[i];
                    int c = tmp.y + dy[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (!visit[r][c] && ary[r][c] == 0) {
                        q.add(new Node(r, c));
                        ary[r][c] = 1;
                        visit[r][c] = true;
                    }
                }
            }
            turn++;
        }
        return turn;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}