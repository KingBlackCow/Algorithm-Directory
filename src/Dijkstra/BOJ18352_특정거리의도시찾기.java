package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ18352_특정거리의도시찾기 {

    static int n, m, range, start;
    static List<Node> list[];
    static Long[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dist = new Long[n + 1];
        long INF = 1000000000;
        for (int i = 1; i <= n; i++) {
            dist[i] = INF;
        }
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(new Node(s, 1));
        }
        dijkstra(start);

        List<Integer> resList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == range) {
                resList.add(i);
            }
        }
        if (resList.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(resList);
            for (Integer i : resList) {
                System.out.println(i);
            }
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = Long.valueOf(0);
        boolean[] visit = new boolean[n + 1];
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.cnt]) continue;
            visit[node.cnt] = true;

            for (Node tmp : list[node.cnt]) {
                if (dist[tmp.cnt] > dist[node.cnt] + tmp.weight) {
                    dist[tmp.cnt] = dist[node.cnt] + tmp.weight;
                    pq.add(new Node(tmp.cnt,dist[tmp.cnt]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int cnt;
        long weight;

        public Node(int cnt, long weight) {
            this.cnt = cnt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }
}