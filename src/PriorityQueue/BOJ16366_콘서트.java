package PriorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ16366_콘서트 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 1;
        while (!pq.isEmpty()) {
            if (cnt++ != pq.poll()) {
                System.out.println(cnt - 1);
                System.exit(0);
            }
        }
        System.out.println(cnt);
    }
}