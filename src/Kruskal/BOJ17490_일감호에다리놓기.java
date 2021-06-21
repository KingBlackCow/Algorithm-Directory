package Kruskal;

import java.io.*;
import java.util.*;


public class BOJ17490_일감호에다리놓기 {
    static int n, m;
    static long k;
    static int[] lecture;
    static int[] parents;
    static List<Edge> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        parents = new int[n + 2];
        make();
        lecture = new int[n + 2];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start != n && end != n) {
                if (start < end) {
                    set.add(start);
                } else {
                    set.add(end);
                }
            } else {
                if ((start == n && end == 1) || (end == n) && (start == 1)) {
                    set.add(n);
                } else {
                    if (start == n) {
                        set.add(end);
                    } else {
                        set.add(start);
                    }

                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (set.contains(i)) continue;
            list.add(new Edge(i, i + 1, 0));
            list.add(new Edge(i + 1, i, 0));
        }
        if (!set.contains(n)) {
            list.add(new Edge(n, 1, 0));
            list.add(new Edge(1, n, 0));
        }
        for (int i = 1; i <= n; i++) {
            list.add(new Edge(n + 1, i, lecture[i]));
            list.add(new Edge(i, n + 1, lecture[i]));
        }
        Collections.sort(list);
        int edgeNum = 0;
        long sum = 0;
        int count = n;
        for (Edge edge : list) {
            if (union(edge.start, edge.end)) {
                edgeNum++;
                sum += edge.weight;
                if (edgeNum == n) break;
                if (edge.start != n + 1 && edge.end != n + 1) {
                    count--;
                }
                if (count == 1) break;
            }
        }
        if (sum > k) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void make() {
        for (int i = 1; i <= n + 1; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = a;
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}