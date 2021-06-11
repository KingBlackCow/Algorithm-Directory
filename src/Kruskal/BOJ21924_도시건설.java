package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21924_도시건설 {
    static int n, m;
    static List<Edge> list;
    static int[] parents;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        make();
        list = new ArrayList<>();
        long count = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
            list.add(new Edge(b, a, c));
            count += c;
        }
        Collections.sort(list);
        int cnt = 0;
        long sum = 0;

        for (Edge edge : list) {
            if (union(edge.from, edge.to)) {
                cnt++;
                sum += edge.weight;
                if (cnt == n - 1) break;
            }

        }

        if (cnt != n - 1) {
            System.out.println(-1);
            return;
        }
        System.out.println(count - sum);
    }

    static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
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
        long weight;

        public Edge(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight,o.weight);
        }
    }
}