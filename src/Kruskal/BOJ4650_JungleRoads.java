package Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4650_JungleRoads {
    static int n;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            parents=new int[n+1];
            make();
            PriorityQueue<Edge> pq = new PriorityQueue<>();
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                String startTmp = st.nextToken();
                char start = startTmp.charAt(0);
                int startNum = Integer.parseInt(st.nextToken());
                for (int j = 0; j < startNum; j++) {
                    String endTmp = st.nextToken();
                    char end = endTmp.charAt(0);
                    int weight = Integer.parseInt(st.nextToken());
                    pq.add(new Edge(start - 'A', end - 'A', weight));
                    pq.add(new Edge(end - 'A', start - 'A', weight));
                }
            }
            int sum = 0;
            int vNum = 0;
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (union(edge.from, edge.to)) {
                    sum += edge.weight;
                    vNum++;
                    if (vNum == n - 1) break;
                }
            }
            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());

    }

    private static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

}

