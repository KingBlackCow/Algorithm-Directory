package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1774_우주선교감 {
    static int V, E;
    static int parents[];
    static List<Edge> edgeList;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = V * (V - 1) / 2;
        int k = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        edgeList = new ArrayList<>();
        make();
        Node[] nodes = new Node[V + 1];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            union(first,second);
        }

        for (int i = 1; i <= V - 1; i++) {
            for (int j = i + 1; j <= V; j++) {
                double weight = distance(nodes[i], nodes[j]);
                edgeList.add(new Edge(i, j, weight));
                edgeList.add(new Edge(j, i, weight));
            }
        }


        Collections.sort(edgeList);
        double result = 0;
        int count = 0;
        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }

        sb.append(String.format("%.2f", result) + "\n");
        System.out.println(sb.toString());
    }

    static double distance(Node node1, Node node2) {
        return Math.sqrt(Math.pow(Math.abs(node1.x - node2.x), 2) + Math.pow(Math.abs(node1.y - node2.y), 2));
    }

    static class Edge implements Comparable<Edge> {
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
