package Dijkstra;

import java.io.*;
import java.util.*;

public class BOJ5972_택배배송_0607 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int v, e;
    static List<Node>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, INF);

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
        dijkstra(1);
        sb.append(dist[v]);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        boolean[] visit = new boolean[v + 1];
        dist[start]=0;
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (visit[tmp.cnt]) continue;
            visit[tmp.cnt] = true;

            for (Node node : list[tmp.cnt]) {
                if (dist[node.cnt] > dist[tmp.cnt] + node.weight) {
                    dist[node.cnt] = dist[tmp.cnt] + node.weight;
                    pq.add(new Node(node.cnt, dist[node.cnt]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int cnt;
        int weight;

        public Node(int cnt, int weight) {
            this.cnt = cnt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}