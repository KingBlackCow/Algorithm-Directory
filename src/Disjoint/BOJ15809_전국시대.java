package Disjoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15809_전국시대 {
    static int n, m;
    static int[] parents;
    static int[] country;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        country = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            country[i] = Integer.parseInt(br.readLine());
        }
        make();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int f = findSet(first);
            int s = findSet(second);
            if (a == 1) {
                union(f, s);
                country[f] += country[s];
                country[s] = 0;
            } else {

                if (country[f] > country[s]) {
                    union(f, s);
                    country[f] -= country[s];
                    country[s] = 0;
                } else if (country[f] < country[s]) {
                    union(s, f);
                    country[s] -= country[f];
                    country[f] = 0;
                } else {
                    country[f] = 0;
                    country[s] = 0;
                }
            }
        }
        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (country[i] != 0) {
                cnt++;
                list.add(country[i]);
            }
        }
        Collections.sort(list);
        System.out.println(cnt);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

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
}
