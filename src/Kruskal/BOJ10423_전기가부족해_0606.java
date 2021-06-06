package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10423_전기가부족해_0606 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

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

    static int V, E, company;
    static int parents[];
    static List<Edge> edgeList;
    private static Set<Integer> set = new HashSet<>();

    static void make() {
        for (int i = 0; i <= V; i++) {
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

        if (!set.contains(aRoot) && set.contains(bRoot)) {
            parents[aRoot] = bRoot;
        } else if (set.contains(aRoot) && !set.contains(bRoot)) {
            parents[bRoot] = aRoot;
        } else {
             parents[bRoot] = aRoot;
        }
        return true;
    }
    private static boolean isSameParent(int a, int b) {
        if (set.contains(findSet(a)) && set.contains(findSet(b))) return true;
        return findSet(a) == findSet(b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        company =Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        make();
        edgeList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= company; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
        }
        Collections.sort(edgeList);
        int res = 0;
        for (Edge edge : edgeList) {
            if (!isSameParent(edge.from, edge.to)) {
                union(edge.from, edge.to);
                res += edge.weight;
            }
        }
        if (res == 0) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}
