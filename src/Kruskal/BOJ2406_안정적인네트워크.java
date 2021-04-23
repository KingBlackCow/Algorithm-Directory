package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2406_안정적인네트워크 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parents;
    static int V, E;
    static List<Edge> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        make();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            union(f, s);

        }
        /*for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int f= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            list.add(new Edge(f,s,1));
        }*/
        int[][] map = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= V; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i!=1 &&i < j) {
                    if(findSet(i)==findSet(j))continue;
                    list.add(new Edge(i, j, map[i][j]));
                }
            }
        }

        Collections.sort(list);
        int weight = 0;
        int cnt = 0;
        List<Edge> resList = new ArrayList<>();
        for (Edge edge : list) {
            if (union(edge.from, edge.end)) {
                weight += edge.weight;
                resList.add(edge);
                if (++cnt == V - 2) break;
            }

        }
        System.out.println(weight + " " + resList.size());
        for (int i = 0; i < resList.size(); i++) {
            System.out.println(resList.get(i).from + " " + resList.get(i).end);
        }

    }

    static void make() {
        for (int i = 1; i <= V; i++) {
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
        int end;
        int weight;

        public Edge(int from, int end, int weight) {
            this.from = from;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
