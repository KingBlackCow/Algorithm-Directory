package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ6198_옥상정원꾸미기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] ary = new long[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        long sum = 0;
        for (int i = 0; i < n-1; i++) {
            long pivot = ary[i];
            long cnt = 0;
            for (int j = i + 1; j < n; j++) {
                if (pivot > ary[j]) {
                    cnt++;
                } else {
                    break;
                }
            }
            sum += cnt;
        }
        System.out.println(sum);
    }
}