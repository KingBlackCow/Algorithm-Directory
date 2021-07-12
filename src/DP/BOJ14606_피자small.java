package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14606_피자small {
    static int n;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        divide(n);
        System.out.println(sum);
    }

    private static void divide(int n) {
        if(n==1){
            return;
        }
        if(n==3){
            sum+=3;
            return;
        }

        if (n % 2 == 0) {
            sum += n / 2 * n / 2;
            divide(n/2);
            divide(n/2);
        } else {
            sum += n / 2 * (n / 2 + 1);
            divide(n/2);
            divide(n/2+1);
        }

    }


}