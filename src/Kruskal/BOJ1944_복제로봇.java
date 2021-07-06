package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1944_복제로봇 {
    static int n, m;
    static char[][] map;
    static boolean[][] visit;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static List<Point> list = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        parents = new int[m + 2];
        make();
        int pointNum = 1;
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'S' || map[i][j] == 'K') {
                    list.add(new Point(i, j, pointNum++));
                }
            }
        }
        for (Point point : list) {
            bfs(point);
        }
        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.from, edge.to)) {
                cnt++;
                sum += edge.weight;
                if (cnt == m) break;
            }
        }
        if (cnt != m) System.out.println(-1);
        else System.out.println(sum);
    }

    private static void make() {
        for (int i = 1; i <= m; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int x) {
        if (x == parents[x]) {
            return parents[x];
        }
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = a;
        return true;
    }

    private static void bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int turn = 0;
        visit = new boolean[n][n];
        visit[start.x][start.y] = true;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Point point = q.poll();
                for (Point cnt : list) {
                    if (cnt.x == point.x && cnt.y == point.y && turn != 0) {
                        pq.add(new Edge(start.num, cnt.num, turn));
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int r = point.x + dr[i];
                    int c = point.y + dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= n) continue;
                    if (!visit[r][c] && map[r][c] != '1') {
                        visit[r][c] = true;
                        q.add(new Point(r, c, 0));
                    }
                }
            }
            turn++;
        }
    }

    static class Point {
        int x;
        int y;
        int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


}