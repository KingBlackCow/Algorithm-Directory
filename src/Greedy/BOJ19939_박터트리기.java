package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19939_박터트리기 {
    static int n;
    static int k;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());
        k =Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 1; i < k; i++) {
            sum+=i;
        }
        n-=sum;
        if(n<k) {
            System.out.println(-1);
            return;
        }
        if(n%k==0)
        {
            System.out.println(k-1);
        }else{
            System.out.println(k);
        }
    }
}