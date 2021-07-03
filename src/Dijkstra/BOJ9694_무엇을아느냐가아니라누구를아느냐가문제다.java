package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9694_무엇을아느냐가아니라누구를아느냐가문제다 {
    static int[] dist;
    static List<Edge> list[];
    static int n, m;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                list[f].add(new Edge(s, w));
                list[s].add(new Edge(f, w));
            }
            dist=new int[m];
            parents= new int[m];
            for (int i = 0; i <m; i++) {
                dist[i]=987654321;
            }
            dijkstra(0);
            sb.append("Case #"+tc+": ");
            if(dist[m-1]==987654321){
                sb.append(-1+"\n");
            }else{
                Stack<Integer> stack = new Stack<>();
                stack.add(m-1);
                int cnt = parents[m-1];
                while (cnt!=0){
                    stack.add(cnt);
                    cnt=parents[cnt];
                }
                stack.add(0);
                while (!stack.isEmpty()){
                    sb.append(stack.pop()+" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge cnt = pq.poll();
            for (Edge edge : list[cnt.to]) {
                if (dist[edge.to] > dist[cnt.to] + edge.weight) {
                    dist[edge.to] = dist[cnt.to] + edge.weight;
                    pq.add(new Edge(edge.to, dist[edge.to]));
                    parents[edge.to]=cnt.to;
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}