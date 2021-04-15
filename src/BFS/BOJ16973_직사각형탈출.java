package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ16973_직사각형탈출 {

    static int n, m, h, w, startX, startY, destX, destY;
    static int[][] ary;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n + 1][m + 1];
        visit = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if (ary[i][j] == 1) list.add(new Node(i, j));
            }
        }
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        destX = Integer.parseInt(st.nextToken());
        destY = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(-1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visit[startX][startY] = true;
        q.add(new Node(startX, startY, 0));
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == destX && tmp.y == destY) {
                System.out.println(tmp.cnt);
                System.exit(0);
            }
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dx[i];
                int c = tmp.y + dy[i];
                if (r < 1 || c < 1 || r >= n || c >= m) continue;
                int rangeX = r + h - 1;
                int rangeY = c + w - 1;
                if (rangeX >= n + 1 || rangeY >= m + 1) continue;
                boolean flag = true;
                for (Node node : list) {
                    if (node.x >= r && node.y >= c && node.x <= rangeX && node.y <= rangeY) {
                        flag=false;
                        break;
                    }
                }


                if (flag && !visit[r][c]) {
                    q.add(new Node(r, c, tmp.cnt + 1));
                    visit[r][c] = true;
                }
            }

        }
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}