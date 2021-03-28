package BellmanFord;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865_웜홀 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 500 * 10000;
    static int n, m, w;
    static List<Edge> edges;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, cost));
                edges.add(new Edge(end, start, cost));
            }
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(start, end, cost * -1));
            }

            if (bellmanFord())
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static boolean bellmanFord() {
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.start] + edge.weight < dist[edge.end]) {
                    dist[edge.end] = dist[edge.start] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.start] + edge.weight < dist[edge.end]){
                return true;
            }
        }
        return false;
    }

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}