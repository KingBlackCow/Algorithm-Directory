package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18116_로봇조립 {
    static int n;
    static int parents[];
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        parents = new int[1000001];
        res = new int[1000001];
        make();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("I")) {
                int f = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                union(f,s);
            } else {
                int f = Integer.parseInt(st.nextToken());
                sb.append(res[findSet(f)] + "\n");
            }

        }
        System.out.println(sb.toString());
    }

    private static void make() {
        for (int i = 1; i <= 1000000; i++) {
            parents[i] = i;
            res[i] = 1;
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
        if(aRoot<bRoot){
            parents[bRoot] = aRoot;
            res[aRoot]+=res[bRoot];
        }else{
            parents[aRoot] = bRoot;
            res[bRoot]+=res[aRoot];
        }
        return true;
    }
}