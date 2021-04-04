package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1939_중량제한 {

    static class Edge implements Comparable<Edge> {
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
    }

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
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        edgeList = new ArrayList<>();
        long result = 0;
        make();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weigh = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weigh));
        }
        st = new StringTokenizer(br.readLine());
        int first=Integer.parseInt(st.nextToken());
        int second=Integer.parseInt(st.nextToken());
        Collections.sort(edgeList);
        int count = 0;
        List<Integer> list=new ArrayList<>();
        for (Edge edge : edgeList) {
            list.add(edge.weight);
            if (union(edge.from, edge.to)) {
                if(findSet(first)==findSet(second)) {
                    Collections.sort(list);
                    result+=list.get(0);
                    break;
                }
                if (++count == V - 1) break;
            }
        }
        System.out.println(result);
    }
}

