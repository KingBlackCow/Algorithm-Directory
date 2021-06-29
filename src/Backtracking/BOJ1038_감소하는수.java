package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1038_감소하는수 {
    static long n, p, q;
    static Map<Long, Long> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        if (n < 10) {
            System.out.println(n);
            return;
        } else if (n > 1022) {
            System.out.println(-1);
            return;
        }
        Queue<Long> q = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            q.add((long)i);
        }
        int turn = 1;
        while (turn <= n) {
            long tmp = q.poll();
            if (turn == n) {
                System.out.println(tmp);
                return;
            }
            turn++;
            long last = tmp % 10;
            for (int i = 0; i < 9; i++) {
                if (last > i) {
                    q.add(tmp * 10 + i);
                } else {
                    break;
                }
            }
        }
    }

}