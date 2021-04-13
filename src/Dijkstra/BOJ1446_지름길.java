package Dijkstra;

import java.io.*;
import java.util.*;


public class BOJ1446_지름길 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int e;
    static List<Node>[] list;
    static int[] dist;
    static int end;


    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        e = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        list = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            list[i] = new ArrayList<>();
        }
        List<Integer> listStart=new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
            listStart.add(start);

        }

        dist = new int[10001];

        for (int i = 0; i <= 10000; i++) {
            dist[i] = i;
        }
        Collections.sort(listStart);
        for (Integer i:listStart) {
            dijkstra(i);
            for (int j = 1; j <= 10000; j++) {
                dist[j]=Math.min(dist[j], dist[j-1]+1);
            }
        }

        sb.append(dist[end] + "\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, dist[start]));

        while (!q.isEmpty()) {
            Node cntNode = q.poll();
            int cnt = cntNode.end;

            for (Node node : list[cnt]) {
                if (dist[node.end] > dist[cnt] + node.weight) {
                    dist[node.end] = dist[cnt] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));

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