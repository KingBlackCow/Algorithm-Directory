package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16562_친구비 {

    /*static class Edge implements Comparable<Edge> {
        int from, to;
        int weight;

        public Edge(int from, int to,  int weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(o.weight, this.weight);
        }
    }*/

    static int V, E, K;
    static int parents[];
//    static List<Edge> edgeList;

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] pay = new int[V + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= V; i++) {
            pay[i] = Integer.parseInt(st.nextToken());
        }
        parents = new int[V + 1];


        make();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }
        boolean visit[] = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            int cnt=findSet(i);
            pay[cnt]=Math.min(pay[cnt],pay[i]);
        }
        long sum = 0;
        for (int i = 1; i <= V; i++) {
            int cnt = parents[i];
            if (!visit[cnt]) {
                sum += pay[cnt];
                visit[cnt] = true;
            }
        }
        if (sum > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }

    }
}

