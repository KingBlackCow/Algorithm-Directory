package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146_다리만들기 {
    public static LinkedList<Integer>[] list;

    public static int[][] map;
    public static boolean[][] visit;
    static boolean[][] visited;
    static int n;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int num = 1;
        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0 && !visit[i][j]) {
                    fill(i, j, num++);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int pivot= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    pivot = bfs(i, j);
                    if (pivot == 0) continue;
                    if (min > pivot) {
                        min = pivot;
                    }

                }
            }
        }


        System.out.println(min);
    }

    private static int bfs(int x, int y) {
        visited = new boolean[n][n];
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        int pivot = map[x][y];
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = node.x + dr[i];
                int c = node.y + dc[i];
                if (r < 0 || r >= n || c < 0 || c >= n) continue;
                if (!visited[r][c] && (map[r][c] == 0 || map[r][c] != pivot)) {
                    if (map[r][c] != 0 && map[r][c] != pivot) {
                        return node.cnt;
                    }
                    visited[r][c] = true;
                    q.add(new Node(r, c, node.cnt + 1));
                }
            }
        }
        return 0;
    }

    private static void fill(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        map[x][y] = num;
        while (!q.isEmpty()) {
            Point point = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = point.x + dr[i];
                int c = point.y + dc[i];
                if (r < 0 || r >= n || c < 0 || c >= n) continue;
                if (!visit[r][c] && map[r][c] != 0) {
                    visit[r][c] = true;
                    map[r][c] = num;
                    q.add(new Point(r, c));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}