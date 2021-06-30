package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11441_합구하기 {
    static int n, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] ary=new int[n+1];
        int[] sum=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
            sum[i]=sum[i-1]+ary[i];
        }
        int t=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int i = 1; i <= t; i++) {
            st=new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            sb.append(sum[b]-sum[a-1]+"\n");
        }
        System.out.println(sb.toString());
    }
}