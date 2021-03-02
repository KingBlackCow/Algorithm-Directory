package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ2847_게임을만든동준이 {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        int[] ary=new int[n];
        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(br.readLine());
        }
        int sum=0;
        for (int i = n-1; i >0; i--) {
            while(ary[i]<=ary[i-1]){
                sum++;
                ary[i-1]--;
            }
        }
        System.out.println(sum);
    }
}

