package Math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13699_점화식 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long[] ary = new long[36];
        ary[0] = 1;
        ary[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; i - 1 - j >= 0; j++) {
                ary[i] += ary[j] * ary[i - 1 - j];
            }

        }
        System.out.println(ary[n]);
    }
}