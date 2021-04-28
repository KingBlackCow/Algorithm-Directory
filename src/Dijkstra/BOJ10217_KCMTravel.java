package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10217_KCMTravel {
    static List<Edge>[] list;
    static int airport;
    static int supportCost;
    static int ticket;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            airport = Integer.parseInt(st.nextToken());
            supportCost = Integer.parseInt(st.nextToken());
            ticket = Integer.parseInt(st.nextToken());
            list = new ArrayList[airport + 1];
            dist = new int[airport + 1][10001];
            for (int i = 1; i <= airport; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i <= ticket; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                list[start].add(new Edge(end, cost, time));
            }
            for (int i = 1; i <= airport; i++) {
                Arrays.fill(dist[i], 1500000000);
            }

            dijkstra(1);
            int min = 1500000000;
            for (int i = 1; i <= supportCost; i++) {
                if (dist[airport][i] != 1500000000) {
                    min = Math.min(min, dist[airport][i]);
                }
            }
            if (min == 1500000000) {
                sb.append("Poor KCM\n");
            } else {
                sb.append(min + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0, 0));
        dist[start][0] = 0;
        while (!pq.isEmpty()) {
            Edge cnt = pq.poll();

            if(dist[cnt.end][cnt.cost]< cnt.time){
                continue;
            }

            for (Edge next : list[cnt.end]) {
                int sum = cnt.cost + next.cost;
                if (sum > supportCost) continue;
                if (dist[next.end][sum] > dist[cnt.end][cnt.cost] + next.time) {
                    dist[next.end][sum] = dist[cnt.end][cnt.cost] + next.time;
                    pq.add(new Edge(next.end, sum, dist[next.end][sum]));
                }
            }

        }
    }

    static class Edge implements Comparable<Edge> {
        int end;
        int cost;
        int time;

        public Edge(int end, int cost, int time) {
            this.end = end;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o) {
            return this.time - o.time;
        }
    }
}