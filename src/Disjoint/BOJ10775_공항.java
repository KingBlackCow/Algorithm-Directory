package Disjoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10775_공항 {
    static int G;
    static int P;

    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P =Integer.parseInt(br.readLine());
        parents=new int[G+1];
        int sum = 0;
        make();
        for (int i = 1; i <= P; i++) {
            int doking = Integer.parseInt(br.readLine());
            int emptyGate = findSet(doking);
            if (emptyGate == 0) {
                break;
            }
            sum++;
            union(emptyGate, emptyGate - 1);
        }

        System.out.println(sum);

    }

    static void make() {
        for (int i = 1; i <= G; i++) {
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

        parents[aRoot] = b;
        return true;
    }
}
