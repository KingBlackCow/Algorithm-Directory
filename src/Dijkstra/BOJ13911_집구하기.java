package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13911_집구하기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static List<Node>[] list;
    static List<Integer> mcDonald = new ArrayList<>();
    static List<Integer> starbucks = new ArrayList<>();
    static int mcRange;
    static int mcNum;
    static int starNum;
    static int starRange;
    static long[] distMC;
    static long[] distStar;
    static Set<Integer> select;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList[V + 1];
        select=new HashSet<>();
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        mcNum = Integer.parseInt(st.nextToken());
        mcRange = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mcNum; i++) {
            mcDonald.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        starNum = Integer.parseInt(st.nextToken());
        starRange = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < starNum; i++) {
            starbucks.add(Integer.parseInt(st.nextToken()));
        }
        long INF = Long.MAX_VALUE;

        long min = INF;

        distMC = new long[V + 1];
        Arrays.fill(distMC, INF);

        dijkstraMC();

        distStar = new long[V + 1];
        Arrays.fill(distStar, INF);
        dijkstraStar();
        for(Integer i :select){
            if (mcDonald.contains(i) || starbucks.contains(i)) continue;
            if (distMC[i] != INF && distStar[i] != INF) {
                min = Math.min(min, distMC[i] + distStar[i]);
            }
        }
        if (min == INF) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dijkstraMC() {
        pq.clear();

        for (Integer i: mcDonald){
            pq.add(new Node(i, 0));
            distMC[i] = 0;
        }
        boolean[] visit = new boolean[V + 1];

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (visit[tmp.end]) continue;
            visit[tmp.end] = true;

            for (Node node : list[tmp.end]) {
                long dist = distMC[tmp.end] + node.weight;
                if (dist > mcRange) continue;
                if (distMC[node.end] > dist) {
                    distMC[node.end] = distMC[tmp.end] + node.weight;
                    pq.add(new Node(node.end, distMC[node.end]));

                }
            }
        }
    }

    private static void dijkstraStar() {
       pq.clear();
        for (Integer i:starbucks){
            pq.add(new Node(i, 0));
            distStar[i] = 0;
        }

        boolean[] visit = new boolean[V + 1];

        while (!pq.isEmpty()) {
            Node tmp = pq.poll();

            if (visit[tmp.end]) continue;
            visit[tmp.end] = true;

            for (Node node : list[tmp.end]) {
                long dist = distStar[tmp.end] + node.weight;
                if (dist > starRange) continue;
                if (distStar[node.end] > dist) {
                    distStar[node.end] = distStar[tmp.end] + node.weight;
                    pq.add(new Node(node.end, distStar[node.end]));
                    select.add(node.end);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight , o.weight);
        }
    }
}
