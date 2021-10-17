package Eratosthenes;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15965_K번째소수 {
    static boolean[] primes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimes();
        int cnt = 1;
        int num = Integer.parseInt(br.readLine());
        if(num==2){
            System.out.println(1);
            System.exit(0);
        }
        for (int i = 3; i <= 50000000; i+=2) {
            if(!primes[i]){
                cnt++;
                if(cnt==num){
                    System.out.println(i);
                    System.exit(0);
                }
            }
        }
    }

    private static void getPrimes() {
        int n = 50000000;
        primes = new boolean[n + 1];
        primes[0] = primes[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                for (int j = i + i; j <= n; j += i) {
                    if(j<=n) {
                        primes[j] = true;
                    }
                }
            }
        }
    }
}


