package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2109_순회강연 {
    public static PriorityQueue<Node> pq;


    public static int[] visit;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        visit = new int[10001];
        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cntDay=node.day;
            if (visit[node.day]==0) {
                visit[node.day] = node.price;
                sum += node.price;
            }else{
                while (--cntDay  > 0){
                    if(visit[cntDay] == 0){
                        visit[cntDay] = node.price;
                        sum += node.price;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {
        int price;
        int day;

        public Node(int price, int day) {
            this.price = price;
            this.day = day;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.price, this.price);
        }
    }


}