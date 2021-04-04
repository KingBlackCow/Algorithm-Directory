package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13418_학교탐방하기 {

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

    static class Edge2 implements Comparable<Edge2> {
        int from, to;
        long weight;

        public Edge2(int from, int to, long weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge2 o) {
            return Long.compare(o.weight, this.weight);
        }
    }

    static int V, E;
    static int parents[];
    static int parents2[];
    static List<Edge> edgeList;
    static List<Edge2> edgeList2;

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

    static void make2() {
        for (int i = 1; i <= V; i++) {
            parents2[i] = i;
        }
    }

    static int findSet2(int a) {
        if (parents2[a] == a) {
            return a;
        }
        return parents2[a] = findSet2(parents2[a]);
    }

    static boolean union2(int a, int b) {
        int aRoot = findSet2(a);
        int bRoot = findSet2(b);
        if (aRoot == bRoot) return false;

        parents2[bRoot] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V+1];
        parents2 = new int[V+1];
        edgeList = new ArrayList<>();
        edgeList2 = new ArrayList<>();
        long resultBest = 0;
        long resultWorst = 0;
        make();
        make2();
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        union(first, second);
        union2(first, second);
        if (weight == 0) {
            resultWorst++;
            resultBest++;
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(from, to, weigh));
            edgeList2.add(new Edge2(from, to, weigh));

        }
        Collections.sort(edgeList);
        Collections.sort(edgeList2);

        int count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                if(edge.weight==0) {
                    resultWorst++;
                }
                if (++count == V - 1) break;
            }
        }

        count=0;
        for (Edge2 edge2 : edgeList2) {
            if (union2(edge2.from, edge2.to)) {
                if(edge2.weight==0) {
                    resultBest++;
                }
                if (++count == V - 1) break;
            }
        }
        int res= (int) Math.pow(resultWorst,2);
        int res2= (int) Math.pow(resultBest,2);
        System.out.println(res-res2);
    }
}
