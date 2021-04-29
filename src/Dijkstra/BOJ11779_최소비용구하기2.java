package Dijkstra;

import java.io.*;
import java.util.*;


public class BOJ11779_최소비용구하기2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int v, e;
    static List<Node>[] list;
    static int[] dist;
    static int[] route = new int[1001];
    static int start;
    static int end;
    static List<Integer> routes;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist = new int[v + 1];

        Arrays.fill(dist, INF);
        routes = new ArrayList<>();
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");
        sb.append(routes.size() + "\n");
        for (int i = routes.size() - 1; i >= 0; i--) {
            sb.append(routes.get(i) + " ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;
        while (!q.isEmpty()) {
            Node cntNode = q.poll();
            int cnt = cntNode.end;

            if (visit[cnt] == true) continue;
            visit[cnt] = true;

            for (Node node : list[cnt]) {
                if (dist[node.end] > dist[cnt] + node.weight) {
                    dist[node.end] = dist[cnt] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                    route[node.end] = cnt;
                }
            }
        }
        int node = end;
        while (node != 0) {
            routes.add(node);
            node = route[node];
        }
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}