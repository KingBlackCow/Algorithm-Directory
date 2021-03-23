package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289_서로소집합 {

    static int n, m;
    static int parent[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n + 1];
            make();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int order = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (order == 0) {
                    union(a, b);
                } else {
                    if (findSet(a) == findSet(b)) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
    }

    private static boolean union(int a, int b) {
        if (findSet(a) == findSet(b)) return false;
        parent[findSet(b)] = a;
        return true;
    }

    private static int findSet(int a) {
        if (parent[a] == a) return a;
        parent[a] = findSet(parent[a]);
        return parent[a];
    }

    private static void make() {
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
    }

}
