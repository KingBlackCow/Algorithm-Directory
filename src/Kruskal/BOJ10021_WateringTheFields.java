package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ10021_WateringTheFields {
    static int n, c;
    static PriorityQueue<Edge> pq;
    static int[] parents;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list.add(new Point(f, s, i + 1));
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Point point = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Point point2 = list.get(j);
                pq.add(new Edge(point.num, point2.num, (int) (Math.pow(point.x - point2.x, 2)
                        + Math.pow(point.y - point2.y, 2))));
            }
        }
        parents = new int[n + 1];
        make();
        int cnt = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.weight < c) continue;
            if (union(edge.from, edge.to)) {
                cnt++;
                sum += edge.weight;
                if (cnt == n - 1) break;
            }
        }
        if(cnt!=n-1){
            System.out.println(-1);
        }else{
            System.out.println(sum);
        }
    }

    private static void make() {
        for (int i = 1; i <= n; i++) {
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