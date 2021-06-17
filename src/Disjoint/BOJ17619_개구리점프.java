package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17619_개구리점프 {
    static int n, q;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        make();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, y, i));
        }
        Collections.sort(list);

        for (int i = 0; i < list.size() - 1; i++) {
            Node pivot = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Node cnt = list.get(j);
                if (pivot.end >= cnt.start) {
                    union(pivot.num, cnt.num);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (findSet(f) == findSet(s)) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int[] parents;

    static void make() {
        for (int i = 1; i <= n; i++) {
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

    static class Node implements Comparable<Node> {
        int start;
        int end;
        int y;
        int num;

        public Node(int start, int end, int y, int num) {
            this.start = start;
            this.end = end;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.start, o.start);
        }
    }


}