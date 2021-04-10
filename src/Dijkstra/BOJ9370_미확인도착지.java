package Dijkstra;

import java.io.*;
import java.util.*;


public class BOJ9370_미확인도착지 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int v, e, t, s, g, h;
    static List<Node>[] list;
    static int[] dist;
    static int[] route;
    static int start;
    static int end;
    static List<Integer> routes;
    static int[] destination;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            destination = new int[t];

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());


            list = new ArrayList[v + 1];

            for (int i = 1; i <= v; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if((start==g&&end==h)||(start==h&&end==g)){
                    list[start].add(new Node(end, 2*weight-1));
                    list[end].add(new Node(start, 2*weight-1));
                }else{
                    list[start].add(new Node(end, 2*weight));
                    list[end].add(new Node(start, 2*weight));
                }

            }
            for (int i = 0; i < t; i++) {
                destination[i] = Integer.parseInt(br.readLine());
            }

            dist = new int[v + 1];
            List<Integer> res=new ArrayList<>();
            for (int i = 0; i < t; i++) {
                Arrays.fill(dist, 10000000);
                routes = new ArrayList<>();
                route = new int[v + 1];
                end = destination[i];
                dijkstra(s);
                if(dist[destination[i]]%2==1)res.add(destination[i]);
            }
            Collections.sort(res);
            for (Integer i: res) {
                sb.append(i+" ");
            }
            sb.append("\n");
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