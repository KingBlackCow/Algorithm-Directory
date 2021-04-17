package Dijkstra;


import java.io.*;
import java.util.*;

public class BOJ14938_서강그라운드 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int v, e, range;
    static List<Node>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        //k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];
        int[] ary = new int[v + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= v; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }

        StringBuilder sb = new StringBuilder();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= v; i++) {
            Arrays.fill(dist, INF);
            dijkstra(i);
            int sum = 0;
            for (int j = 1; j <= v; j++) {
                if (dist[j] > range) continue;
                sum += ary[j];
            }
            max = Math.max(max, sum);
        }
        sb.append(max);


        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int cnt = tmp.node;

            if (visit[cnt] == true) continue;
            visit[cnt] = true;

            for (Node node : list[cnt]) {
                if (dist[node.node] > dist[cnt] + node.weight) {
                    dist[node.node] = dist[cnt] + node.weight;
                    q.add(new Node(node.node, dist[node.node]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}