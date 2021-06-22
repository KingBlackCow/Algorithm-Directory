package Disjoint;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;


public class BOJ14594_동방프로젝트small {
    static int n;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        parents= new int[n+1];
        make();
        int m =Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            int f= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            for (int j = f+1; j <= s; j++) {
                union(f,j);

            }
        }
        HashSet<Integer> set= new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(findSet(i));
        }
        System.out.println(set.size());

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

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = a;
        return true;
    }

}