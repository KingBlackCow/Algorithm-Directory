package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 정올1863_종교 {

    static int n, m;
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        make();
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(i == parent[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
        //System.out.println(set.size());
    }

    private static boolean union(int a, int b) {
        int aRoot=findSet(a);
        int bRoot=findSet(b);
        if (aRoot == bRoot) return false;

        parent[bRoot] = a;
        return true;
    }

    private static int findSet(int a) {
        if (parent[a] == a) return a;
        parent[a] = findSet(parent[a]);
        return parent[a];
    }

    private static void make() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

}
