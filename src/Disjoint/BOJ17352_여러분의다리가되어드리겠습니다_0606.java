package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17352_여러분의다리가되어드리겠습니다_0606 {
    static int V;
    static int parents[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        parents = new int[V + 1];
        make();
        for (int i = 0; i < V - 2; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 1; i <= V - 1; i++) {
            for (int j = i + 1; j <= V; j++) {
                if (findSet(i) != findSet(j)) {
                    System.out.println(i + " " + j);
                    System.exit(0);
                }
            }
        }
    }

    private static void make() {
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
    }

    private static int findSet(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = findSet(parents[x]);
    }

    private static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        parents[bRoot] = a;
        return true;
    }
}
