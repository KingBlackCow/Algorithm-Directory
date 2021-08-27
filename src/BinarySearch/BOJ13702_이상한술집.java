package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13702_이상한술집 {
    static int n, m;
    static long[] ary;
    static int min = 0;
    static long max = 0;
    static int cntMax = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new long[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, ary[i]);
        }
        long left = 1;
        long right = max;
        while (left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (mid != 0) {
                    cnt += ary[i] / mid;
                }
            }
            if (cnt >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(left<1){
            System.out.println(0);
            System.exit(0);
        }
        System.out.println(left - 1);


    }


}