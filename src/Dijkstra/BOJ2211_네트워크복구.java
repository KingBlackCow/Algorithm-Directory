package Dijkstra;


import java.io.*;
import java.util.*;

public class BOJ2211_네트워크복구 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int v, e, range;
    static List<Node>[] list;
    static List<int[]> res;
    static int[] dist;
    static int[] ary;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        //k = Integer.parseInt(br.readLine());
        list = new ArrayList[v + 1];
        dist = new int[v + 1];
        ary = new int[v + 1];
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
        Arrays.fill(dist, INF);
        res = new ArrayList<>();
        dijkstra(1);
        int sum=0;
        for (int i = 0; i < ary.length; i++) {
            if(ary[i]!=0){
                sum++;
            }
        }
        System.out.println(sum);
        for (int i = 2; i < ary.length; i++) {
            System.out.println(i+" "+ary[i]);
        }


        //bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int cnt = tmp.node;

            if (visit[cnt] == true) continue;
            visit[cnt] = true;

            for (Node node : list[cnt]) {
                if (dist[node.node] > dist[cnt] + node.weight) {

                        dist[node.node] = dist[cnt] + node.weight;
                        q.add(new Node(node.node, dist[node.node]));
                        //res.add(new int[]{cnt, node.node});
                        ary[node.node] = cnt;

                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}