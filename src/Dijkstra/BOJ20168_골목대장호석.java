package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ20168_골목대장호석 {

    static int n, m;
    static int[] dist;
    static int start, end, myMoney;
    static List<Edge> list[];
    static int[] min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        myMoney = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        min = new int[2];
        min[0] = 987654321;

        for (int i = 1; i <= n; i++) {
            dist[i] = 987654321;
        }
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Edge(e, w, w));
            list[e].add(new Edge(s, w, w));
        }
        dijksta(start);
        //min[0]는 간선최대값
        //min[1]는 가격
        //dist[end]가는데 비용
        if(min[0]==987654321){
            System.out.println(-1);
        }else{
            System.out.println(min[0]);
        }
    }

    static void dijksta(int start) {
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0, 0));
        while (!pq.isEmpty()) {
            Edge cnt = pq.poll();
            for (Edge edge : list[cnt.to]) {
                if (dist[edge.to] > dist[cnt.to] + edge.weight) {
                    dist[edge.to] = dist[cnt.to] + edge.weight;

                    pq.add(new Edge(edge.to, dist[edge.to], Math.max(cnt.max, edge.weight)));
                }
                if (dist[cnt.to] + edge.weight <= myMoney && edge.to == end) {
                    if (min[0] > Math.max(cnt.max,edge.weight)) {
                        min[0] = Math.max(cnt.max,edge.weight);
                        min[1] = dist[cnt.to] + edge.weight;
                    }
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        int max;

        public Edge(int to, int weight, int max) {
            this.to = to;
            this.weight = weight;
            this.max = max;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}