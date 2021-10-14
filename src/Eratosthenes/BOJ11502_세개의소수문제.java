package Eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ11502_세개의소수문제 {
    static int[] ary;
    static int[] map;
    static int ans = 0;
    static boolean[] prime;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        getPrimes(1000);
        for (int i = 2; i <= 1000; i++) {
            if (!prime[i]) {
                list.add(i);
            }
        }
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            boolean flag = true;
            int a=0, b=0, c=0;
            out:
            for (Integer i : list) {
                for (Integer j : list) {
                    for (Integer k : list) {
                        if (!prime[i] && !prime[j] && !prime[k]) {
                            if (i + j + k == num) {
                                a = i;
                                b = j;
                                c = k;
                                flag = false;
                                break out;
                            }
                        }
                    }
                }
            }
            if(flag){
                sb.append(0+"\n");
            }else{
                sb.append(a+" "+b+" "+c+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static void getPrimes(int n) {
        prime = new boolean[n + 1];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!prime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

    }
}


