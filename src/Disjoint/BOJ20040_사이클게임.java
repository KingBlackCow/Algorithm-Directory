package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ20040_사이클게임 {

    static class Edge {
        int from, to;

        public Edge(int from, int to) {

            this.from = from;
            this.to = to;

        }

    }

    static int V, E;
    static int parents[];
    static List<Edge> edgeList;

    static void make() {
        for (int i = 0; i < V; i++) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V];
        edgeList = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to));
        }

        make();
        int result = 0;
        int turn = 1;
        for (Edge edge : edgeList) {
            if(!union(edge.from, edge.to)) {
                result = turn;
                break;
            }
            turn++;
        }
        System.out.println(result);
    }
}
