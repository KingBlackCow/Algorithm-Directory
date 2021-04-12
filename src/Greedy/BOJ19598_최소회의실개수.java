package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ19598_최소회의실개수 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, 1));
            pq.add(new Node(end, -1));
        }
        int cnt=0;
        int res=0;
        while (!pq.isEmpty()){
            cnt+=pq.poll().end;
            res =Math.max(res,cnt);
        }


        sb.append(res + "\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }


    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.start, o.start);
        }
    }
}