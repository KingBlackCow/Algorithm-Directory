package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ17396_백도어 {

    static int n, m;
    static long[] dist;
    static int[] map;
    static List<Node>[] list;
    static int[] ary;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n];
        dist = new long[n];
        map = new int[n];
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            //if ((ary[f] == 1 || ary[s] == 1) && ((s != n - 1) && (f != n - 1))) continue;
            list[f].add(new Node(s, weight));
            list[s].add(new Node(f, weight));
        }
        dijkstra(0);
        if (dist[n - 1] == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist[n - 1]);
    }

    private static void dijkstra(int x) {
        dist[x] = 0;
        boolean[] visit = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.cnt]) continue;
            visit[node.cnt] = true;

            for (Node tmp : list[node.cnt]) {
                if (ary[tmp.cnt] == 1 && tmp.cnt != n - 1) continue;
                if (dist[tmp.cnt] > dist[node.cnt] + tmp.weight) {
                    dist[tmp.cnt] = dist[node.cnt] + tmp.weight;
                    pq.add(new Node(tmp.cnt, dist[tmp.cnt]));
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