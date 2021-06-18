package Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class BOJ9237_이장님초대 {
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max =Integer.MIN_VALUE;
        Integer[] ary= new Integer[n];
        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ary, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            max=Math.max(max, ary[i]+i+2);
        }
        bw.write(max+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
