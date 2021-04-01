package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16398_행성연결 {

    static class Edge implements Comparable<Edge> {
        int from, to;
        long weight;

        public Edge(int from, int to, long weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
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
        E = V*V;
        parents = new int[V];
        edgeList = new ArrayList<>();

        long map[][]=new long[V][V];
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < V; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
               if(i==j)continue;
                   edgeList.add(new Edge(i, j, map[i][j]));

            }
        }
        Collections.sort(edgeList);

        make();
        long result = 0;
        int count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }
        System.out.println(result);
    }
}
