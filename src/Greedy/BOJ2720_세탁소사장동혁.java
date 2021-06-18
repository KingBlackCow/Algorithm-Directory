package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class BOJ2720_세탁소사장동혁 {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] ary = {25, 10, 5, 1};
        while (n-- > 0) {
            int[] res = new int[4];
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                if (ary[i] != 0) {
                    res[i] = t / ary[i];
                    t = t % ary[i];
                }
            }
            for (int i = 0; i < 4; i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
