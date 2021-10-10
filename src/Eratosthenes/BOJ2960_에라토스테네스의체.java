package Eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960_에라토스테네스의체 {
    static StringBuilder sb=new StringBuilder();
    static int n,m;
    static boolean[] prime;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ans=getPrimes(n,m);
        System.out.print(ans);
    }

    private static int getPrimes(int n,int m) {
        prime = new boolean[n+1];
        prime[0]= prime[1] = true;

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(!prime[i]) {
                cnt++;
                if(cnt == m){
                    return i;
                }
                for (int j = i + i; j <= n; j = j + i) {
                    if (!prime[j]) {
                        prime[j] = true;
                        cnt++;
                        if (cnt == m) {
                            return j;
                        }
                    }
                }
            }

        }
        return -1;
    }
}