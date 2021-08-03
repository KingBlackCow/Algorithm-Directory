package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ7044_BadCowtractors {
    static int n, m;
    static int[] parents;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        make();
        pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(f, s, w));
            pq.add(new Edge(s, f, w));
        }
        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (union(edge.from, edge.to)) {
                sum += edge.weight;
                cnt++;
                if (cnt == n - 1) break;
            }
        }
        if(cnt!=n-1){
            System.out.println(-1);
            System.exit(0);
        }
        System.out.println(sum);
    }

    static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) return false;
        parents[bRoot] = a;
        return true;
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
            return Integer.compare(o.weight, this.weight);
        }
    }
}

