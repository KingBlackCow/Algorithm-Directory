package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1758_알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int ary[] = new int[n];
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ary);
        long sum = 0;
        int cnt = 1;
        for (int i = n-1; i >= 0; i--) {
            long tmp = ary[i] - (cnt++ - 1);
            sum += tmp > 0 ? tmp : 0;
        }
        System.out.println(sum);

    }

}