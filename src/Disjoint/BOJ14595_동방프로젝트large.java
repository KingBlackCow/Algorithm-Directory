package Disjoint;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ14595_동방프로젝트large {
    static int n;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int dongbang=n;
        parents = new int[n + 1];
        make();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            while (findSet(f) != findSet(s)) {
                --dongbang;

                int next = findSet(f) + 1;
                union(f, s);
                f = next;
            }
        }

        System.out.println(dongbang);

        bw.flush();
        bw.close();
        br.close();
    }

    static void make() {
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = findSet(parents[a]);
    }

    static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return;

        parents[aRoot] = bRoot;
    }

}