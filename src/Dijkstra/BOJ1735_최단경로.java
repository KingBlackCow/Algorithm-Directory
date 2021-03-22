package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1735_최단경로 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = Integer.MAX_VALUE;
    static int v,e;
    static List<Node>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v + 1];
        distance = new int[v + 1];
        int start = Integer.parseInt(br.readLine());
        Arrays.fill(distance, INF);

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start2 = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start2].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            if(distance[i]!=Integer.MAX_VALUE){
                sb.append(distance[i] + "\n");
            }else{
                sb.append("INF"+"\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){

        boolean[] visit = new boolean[v + 1];

        distance[start] = 0;
        for (int i = 1; i <= v; i++) {
            int minIdx = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= v; j++) {
                if (!visit[j] && distance[j] < min) {
                    min = distance[j];
                    minIdx = j;
                }
            }
            if(minIdx==Integer.MAX_VALUE||minIdx==-1)continue;
            visit[minIdx] = true;
            for (Node j:list[minIdx]) {
                if (!visit[j.cnt] && distance[j.cnt] > distance[minIdx] + j.weight) {
                    distance[j.cnt] = distance[minIdx] + j.weight;
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int cnt, weight;

        public Node(int cnt, int weight){
            this.cnt = cnt;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}