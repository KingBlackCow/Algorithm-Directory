package Greedy;

import java.io.*;
import java.util.*;

public class BOJ1744_수묶기 {
    static int n;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                list.add(tmp);
            } else {
                list2.add(tmp);
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>(list);
        Collections.sort(list2);
        Queue<Integer> q2 = new LinkedList<>(list2);
        int sum = 0;

        while (!q.isEmpty()) {
            if (q.size() >= 2) {
                int a=q.poll();
                int b=q.poll();
                if(a==1||b==1)sum+= a+b;
                else sum += a * b;
            } else if (q.size() == 1) {
                sum += q.poll();
            }
        }
        while (!q2.isEmpty()) {
            if (q2.size() >= 2) {
                sum += q2.poll() * q2.poll();
            } else if (q2.size() == 1) {
                sum += q2.poll();
            }
        }
        System.out.println(sum);
        bw.flush();
        bw.close();
        br.close();
    }


}
