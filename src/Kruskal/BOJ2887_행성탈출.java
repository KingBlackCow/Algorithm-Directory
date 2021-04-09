package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2887_행성탈출 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {

            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V;
    static int parents[];
    static PriorityQueue<Edge> edgeList;
    static int pivotX, pivotY, pivotZ;

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
        parents = new int[V];
        edgeList = new PriorityQueue<>();
        List<Node> nodes = new ArrayList<>();


        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes.add(new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        pivotX = nodes.get(0).x;
        pivotY = nodes.get(0).y;
        pivotZ = nodes.get(0).z;
        int pivot = nodes.get(0).num;
        for (int i = 1; i < V; i++) {
            edgeList.add(new Edge(pivot, nodes.get(i).num, Math.min(Math.min(Math.abs(pivotX - nodes.get(i).x), Math.abs(pivotY - nodes.get(i).y)), Math.abs(pivotZ - nodes.get(i).z))));
            pivotX = nodes.get(i).x;
            pivotY = nodes.get(i).y;
            pivotZ = nodes.get(i).z;
            pivot = nodes.get(i).num;
        }


        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.y, o2.y);
            }
        });
        pivotX = nodes.get(0).x;
        pivotY = nodes.get(0).y;
        pivotZ = nodes.get(0).z;
        pivot = nodes.get(0).num;
        for (int i = 1; i < V; i++) {
            edgeList.add(new Edge(pivot, nodes.get(i).num, Math.min(Math.min(Math.abs(pivotX - nodes.get(i).x), Math.abs(pivotY - nodes.get(i).y)), Math.abs(pivotZ - nodes.get(i).z))));
            pivotX = nodes.get(i).x;
            pivotY = nodes.get(i).y;
            pivotZ = nodes.get(i).z;
            pivot = nodes.get(i).num;
        }


        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.z, o2.z);
            }
        });
        pivotX = nodes.get(0).x;
        pivotY = nodes.get(0).y;
        pivotZ = nodes.get(0).z;
        pivot = nodes.get(0).num;
        for (int i = 1; i < V; i++) {
            edgeList.add(new Edge(pivot, nodes.get(i).num, Math.min(Math.min(Math.abs(pivotX - nodes.get(i).x), Math.abs(pivotY - nodes.get(i).y)), Math.abs(pivotZ - nodes.get(i).z))));
            pivotX = nodes.get(i).x;
            pivotY = nodes.get(i).y;
            pivotZ = nodes.get(i).z;
            pivot = nodes.get(i).num;
        }
        make();
        int result = 0;
        int count = 0;

        while (!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }
        System.out.println(result);
    }

    static class Node {
        int num;
        int x;
        int y;
        int z;


        public Node(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }


    }
}
