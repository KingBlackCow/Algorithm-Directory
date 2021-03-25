package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA0324_하나로 {

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
            return Double.compare(this.weight,o.weight);
        }
    }

    static int V, E;
    static int parents[];
    static Edge[] edgeList;

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
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {

            V = Integer.parseInt(br.readLine());
            Node[] node = new Node[V];
            for (int i = 0; i < V; i++) {
                node[i]=new Node(0,0);
            }
            E=V*(V-1)/2;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < V; j++) {
                    if (i == 0) {
                        node[j].x = Long.parseLong(st.nextToken());
                    } else {
                        node[j].y = Long.parseLong(st.nextToken());
                    }
                }
            }
            double k= Double.parseDouble(br.readLine());

            parents = new int[V];
            edgeList = new Edge[E];
            int edgeListCount=0;
            for (int i = 0; i < V; i++) {

                for (int j = i+1; j < V; j++) {
                    int from = i;
                    int to = j;
                    double weight =  Math.pow(distance(node[i].x,node[i].y,node[j].x,node[j].y),2)*k;
                    edgeList[edgeListCount++] = new Edge(from, to, weight);
                }
            }
            Arrays.sort(edgeList);

            make();
            double result = 0;
            int count = 0;

            for (Edge edge : edgeList) {
                if (union(edge.from, edge.to)) {
                    result += edge.weight;
                    if (++count == V - 1) break;
                }
            }
            System.out.println("#"+tc+" "+Math.round(result));
        }

    }

    static class Node {
        long x;
        long y;

        Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static double distance(long x1, long y1, long x2, long y2) {
        double res = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        return res;
    }
}
