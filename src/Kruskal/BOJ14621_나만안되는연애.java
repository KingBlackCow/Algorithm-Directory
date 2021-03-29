package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14621_나만안되는연애 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V, E;
    static int parents[];
    static List<Edge> edgeList;
    static String[] sex;

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

        sex = new String[V + 1];
        parents = new int[V + 1];
        edgeList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= V; i++) {
            sex[i] = st.nextToken();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (sex[from].equals(sex[to])) continue;
            edgeList.add(new Edge(from, to, weight));
        }
        Collections.sort(edgeList);

        make();
        int result = 0;
        int count = 0;
        boolean res = false;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) {
                    res = true;
                    break;
                }
            }
        }
        if (result == 0 || !res) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
