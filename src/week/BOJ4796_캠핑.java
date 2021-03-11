package week;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ4796_캠핑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int turn=1;
        while (true){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==0&&b==0&&c==0)break;
            int sum=0;
            int res1=c/b;
            int res2=c%b;
            sum+=res1*a;
            if(res2>a)res2=a;
            sum+=res2;
            System.out.println("Case "+turn +": "+ sum);
            turn++;
        }


        bw.flush();
        bw.close();
        br.close();
    }


}