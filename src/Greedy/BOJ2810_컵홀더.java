package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class BOJ2810_컵홀더 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String str=br.readLine();
        int res=1;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='L'){
                i++;
            }
            res++;
        }
        System.out.println(Math.min(n,res));
    }
}

