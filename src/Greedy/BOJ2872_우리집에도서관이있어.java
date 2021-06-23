package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ2872_우리집에도서관이있어 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ary = new int[n + 1];
        int start = 0;
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            if (ary[i] == n) {
                start = i;
            }
        }
        int cnt = 0;
        int res = 0;
        int pivot= ary[start - cnt];
        while (true) {
            if(start-cnt<=0)break;
            if (ary[start-cnt] == pivot) {
               res++;
               pivot--;
            }
            cnt++;
        }
        System.out.println(n - res);

    }


}