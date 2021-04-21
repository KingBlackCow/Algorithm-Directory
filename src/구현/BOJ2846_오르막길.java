package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2846_오르막길 {

    static int N;
    static int[] ary;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ary = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        int pivot = ary[0];
        if(N==1) {
            System.out.println(ary[0]);
            System.exit(0);
        }
        if(N>1) {
            for (int i = 1; i < N; i++) {
                if (ary[i - 1] < ary[i]) {
                    max = Math.max(max, ary[i] - pivot);
                } else {
                    pivot = ary[i];
                }
            }
        }
        if(max==Integer.MIN_VALUE) System.out.println(0);
        else System.out.println(max);

    }
}