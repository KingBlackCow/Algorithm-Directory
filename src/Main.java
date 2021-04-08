
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

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

    static int V, E;
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
        Node[] nodes = new Node[V-1];
        st = new StringTokenizer(br.readLine(), " ");
        pivotX=Integer.parseInt(st.nextToken());
        pivotY=Integer.parseInt(st.nextToken());
        pivotZ=Integer.parseInt(st.nextToken());
        for (int i = 0; i < V-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes);
        int pivot=0;
        for (int i = 0; i < V-1 ; i++) {
            edgeList.add(new Edge(pivot++,i+1,Math.min(Math.min(Math.abs(pivotX-nodes[i].x),Math.abs(pivotY-nodes[i].y)),Math.abs(pivotZ-nodes[i].z))));
            pivotX=nodes[i].x;
            pivotY=nodes[i].y;
            pivotZ=nodes[i].z;
        }


        make();
        int result = 0;
        int count = 0;

        /*for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }*/

        /*while (!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == V - 1) break;
            }
        }*/
        while (!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            result += edge.weight;

        }
        System.out.println(result);
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int z;
        int weight;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.weight=Math.min(Math.min(Math.abs(pivotX-x),Math.abs(pivotY-y)),Math.abs(pivotZ-z));
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }
    }
}
