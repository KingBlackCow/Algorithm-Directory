package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2437_저울 {
    static int n;
    static int[] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        ary = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ary[i] > ans + 1) {
                break;
            }
            ans += ary[i];
        }
        System.out.println(ans + 1);
        bw.flush();
        bw.close();
        br.close();
    }


}
