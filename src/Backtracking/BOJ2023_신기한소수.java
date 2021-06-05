package Backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2023_신기한소수 {
    static int n;
    static int[] init = {2, 3, 5, 7};
    static int[] prime = {1, 3, 5, 7, 9};
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < init.length; i++) {
            dfs(init[i], 1);
        }
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x, int len) {
        if (len == n) {
            list.add(x);
            return;
        }
        for (int i = 0; i < prime.length; i++) {
            x *= 10;
            x += prime[i];
            if (isPrime(x)) {
                dfs(x, len + 1);
            }
            x -= prime[i];
            x /= 10;

        }
    }

    private static boolean isPrime(int x) {
        for (int j = 2; j < x; j++) {
            if (x % j == 0) {
                return false;
            }
        }
        return true;
    }
}
