package Kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16202_MST게임 {

    static int n, m, turn;
    static List<Edge> edges;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        turn = Integer.parseInt(st.nextToken());
        edges = new ArrayList<>();
        parents = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int weight = i + 1;
            edges.add(new Edge(f, s, weight));
            edges.add(new Edge(s, f, weight));
        }
        for (int i = 0; i < turn; i++) {
            make();
            Collections.sort(edges);
            int result = 0;
            int count = 0;
            boolean check = true;
            for (Edge edge : edges) {
                if (union(edge.from, edge.end)) {
                    result += edge.weight;
                    if (++count == n - 1){
                        check=false;
                        break;
                    }
                }
            }
            if(!check){
                System.out.println(result);
            }else{
                System.out.println(0);
            }
            edges.remove(0);
            edges.remove(0);
        }
    }

    private static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    private static boolean union(int a, int b) {
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