package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6087_레이저통신 {
    static int n, m;
    static char[][] map;
    static int sX, sY, eX, eY;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][][] visit;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new int[n][m][4];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'C') {
                    if (flag) {
                        sX = i;
                        sY = j;
                        flag = false;
                    } else {
                        eX = i;
                        eY = j;
                    }
                }
            }
        }
        bfs();

        sb.append(res + "\n");
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sX, sY, 0));
        q.add(new Node(sX, sY, 1));
        q.add(new Node(sX, sY, 2));
        q.add(new Node(sX, sY, 3));
        visit = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    visit[i][j][k] = 987654321;
                }
            }
        }
        visit[sX][sY][0] = visit[sX][sY][1] = visit[sX][sY][2] = visit[sX][sY][3] = 0;

        while (!q.isEmpty()) {
            Node cnt = q.poll();
            int past = cnt.past;
            if (cnt.x == eX && cnt.y == eY) {
                res = Math.min(visit[cnt.x][cnt.y][past], res);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int r = cnt.x + dr[i];
                int c = cnt.y + dc[i];

                if (r < 0 || c < 0 || r > n - 1 || c > m - 1) continue;
                if (map[r][c] == '*') continue;
                int pivot = 1;
                if (i == past) {
                    pivot = 0;
                }
                if (visit[r][c][i] > visit[cnt.x][cnt.y][past] + pivot) {
                    visit[r][c][i] = visit[cnt.x][cnt.y][past] + pivot;
                    q.add(new Node(r, c, i));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int past;

        public Node(int x, int y, int past) {
            this.x = x;
            this.y = y;
            this.past = past;
        }
    }
}



