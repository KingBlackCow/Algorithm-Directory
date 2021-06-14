package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18223_민준이와마산그리고건우 {
    static int v, e, p;
    static int[] dist;
    static List<Node> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        dist = new int[v + 1];
        list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= v; i++) {
            dist[i] = 987654321;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[f].add(new Node(s, w));
            list[s].add(new Node(f, w));
        }

        if (dijkstra(1)) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    private static boolean dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<Integer> nodelist = new ArrayList<>();
        nodelist.add(start);
        int min = Integer.MAX_VALUE;
        boolean res = false;
        pq.add(new Node(start, 0, nodelist));
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            for (Node node : list[tmp.to]) {
                if (dist[node.to] >= dist[tmp.to] + node.weight) {
                    dist[node.to] = dist[tmp.to] + node.weight;
                    List<Integer> tmpList = new ArrayList<>(tmp.nodelist);
                    tmpList.add(node.to);
                    pq.add(new Node(node.to, dist[node.to], tmpList));
                }
            }
            if (tmp.to == v) {
                if (min > dist[tmp.to]) {
                    min = dist[tmp.to];
                    if (tmp.nodelist.contains(p)) {
                        res = true;
                    } else {
                        res = false;
                    }
                } else if (min == dist[tmp.to]) {
                    if (tmp.nodelist.contains(p)) {
                        res = true;
                    }
                }
            }
        }
        return res;
    }

    static class Node implements Comparable<Node> {
        int to;
        int weight;
        List<Integer> nodelist;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public Node(int to, int weight, List<Integer> nodelist) {
            this.to = to;
            this.weight = weight;
            this.nodelist = nodelist;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}