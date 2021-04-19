package Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ13424_비밀모임 {

    static int n, m;
    static List<Node>[] list;
    static int[] friend;
    static int dist[];
    static int distRes[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        while (T-- >0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list=new ArrayList[n+1];
            dist=new int[n+1];
            distRes=new int[n+1];
            int INF=100000000;

            for (int i = 1; i <= n; i++) {
                list[i]=new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int f=Integer.parseInt(st.nextToken());
                int s=Integer.parseInt(st.nextToken());
                int weight =Integer.parseInt(st.nextToken());
                list[f].add(new Node(s,weight));
                list[s].add(new Node(f,weight));
            }
            int friendNum=Integer.parseInt(br.readLine());
            friend=new int[friendNum];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < friendNum; i++) {
                friend[i]=Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < friendNum; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[j]=INF;
                }
                dijkstra(friend[i]);
                for (int j = 1; j <= n; j++) {
                    distRes[j]+=dist[j];
                }
            }
            int min= Integer.MAX_VALUE;
            int minVertex = 0;
            for (int j = 1; j <= n; j++) {
                if(min>distRes[j]){
                    minVertex=j;
                    min=distRes[j];
                }
            }
            sb.append(minVertex+"\n");
        }
        System.out.println(sb.toString());


    }

    private static void dijkstra(int start) {
        boolean[] visit=new boolean[n+1];
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] =0;
        while(!pq.isEmpty()){
            Node tmp=pq.poll();

            if(visit[tmp.cnt])continue;
            visit[tmp.cnt]=true;

            for(Node node:list[tmp.cnt]) {
                if(dist[node.cnt]>dist[tmp.cnt]+node.weight){
                    dist[node.cnt]=dist[tmp.cnt]+node.weight;
                    pq.add(new Node(node.cnt, dist[node.cnt]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int cnt;
        int weight;

        public Node(int cnt, int weight) {
            this.cnt = cnt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
}