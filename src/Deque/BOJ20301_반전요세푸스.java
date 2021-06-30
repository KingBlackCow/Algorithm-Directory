package Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20301_반전요세푸스 {
    static int n, k, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }
        int turn = 0;
        boolean rotate = true;
        List<Integer> list =new ArrayList<>();
        while (!dq.isEmpty()) {
            if (rotate) {
                for (int i = 0; i < k-1; i++) {
                    dq.addLast(dq.pollFirst());
                }
                list.add(dq.pollFirst());
            } else {
                for (int i = 0; i < k-1; i++) {
                    dq.addFirst(dq.pollLast());
                }
                list.add(dq.pollLast());
            }
            turn++;
            if (turn % m == 0) {
                rotate = !rotate;
            }
        }
        for (Integer i:list) {
            System.out.println(i);
        }
    }
}