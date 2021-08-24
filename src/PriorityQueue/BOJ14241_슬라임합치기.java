package PriorityQueue;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ14241_슬라임합치기 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;
        while (pq.size()!=1){
            int a =pq.poll();
            int b =pq.poll();
            sum+=a*b;
            pq.add(a+b);
        }
        System.out.println(sum);

        bw.flush();
        bw.close();
        br.close();
    }


}
