package Math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1292_쉽게푸는문제 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[1001];
        int[] ary = new int[1001];
        int cnt = 1;
        int count = 0;
        for (int i = 1; i < 1001; i++) {
            ary[i] = cnt;
            sum[i] = sum[i - 1] + ary[i];
            count++;
            if (count == cnt) {
                cnt++;
                count = 0;
            }
        }
        System.out.println(sum[m] - sum[n-1]);
    }
}