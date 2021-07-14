package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2828_사과담기게임 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[] ary = new int[k];
        for (int i = 0; i < k; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }
        int left = 1;
        int right = m;
        int res = 0;

        for (int i = 0; i < k; i++) {
            if (ary[i] > right) {
                res += ary[i] - right;
                right = ary[i];
                left = right - (m - 1);
            } else if (ary[i] < left) {
                res += left - ary[i];
                left = ary[i];
                right = left + (m - 1);
            }
        }
        System.out.println(res);
    }

}