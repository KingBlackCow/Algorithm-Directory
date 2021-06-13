package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ13904_과제 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Node[] node=new Node[n+1];
        int[] res=new int[1001];
        for (int i = 0; i <= n; i++) {
            node[i]=new Node(0,0);
        }

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int f=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            node[i]=new Node(f,s);
        }
        Arrays.sort(node);
        int sum= 0;
        for (int i = 0; i < n; i++) {
            if(res[node[i].day]==0){
                res[node[i].day]=node[i].score;
                sum+=node[i].score;
            }else{
                int cnt=node[i].day;
                while (--cnt >0){
                    if(res[cnt]==0){
                        res[cnt]=node[i].score;
                        sum+=node[i].score;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
    static class Node implements Comparable<Node>{
        int day;
        int score;

        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return o.score-this.score;
        }
    }


}