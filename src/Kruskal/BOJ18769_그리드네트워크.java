package Kruskal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18769_그리드네트워크 {
    static PriorityQueue<Edge> pq;
    static int T;
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            make();
            pq = new PriorityQueue<>();


            for (int i = 0; i < n * m; i += m) {
                st = new StringTokenizer(br.readLine());
                int c = 0;
                while (st.hasMoreTokens()) {
                    int weight = Integer.parseInt(st.nextToken());
                    pq.add(new Edge(i + c, i + c + 1, weight));
                    c++;
                }
            }

            for (int i = 0; i < n * m - m; i += m) {
                st = new StringTokenizer(br.readLine());
                int c = 0;
                while (st.hasMoreTokens()) {
                    int weight = Integer.parseInt(st.nextToken());
                    pq.add(new Edge(i + c, i + c + m, weight));
                    c++;
                }
            }
            int sum = 0;
            int cnt = 0;
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (union(edge.from, edge.to)) {
                    cnt++;
                    sum += edge.weight;
                    if (cnt == n * m - 1) break;
                }
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb.toString());
    }

    static void make() {
        parents = new int[n * m];
        for (int i = 0; i < n * m; i++) {
            parents[i] = i;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return false;
        parents[bRoot] = a;
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


