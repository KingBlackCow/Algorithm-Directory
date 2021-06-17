package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2693_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T=Integer.parseInt(st.nextToken());
        int[] a=new int[10];
        while (T-- > 0){
            st=new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                a[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            sb.append(a[7]+"\n");
        }
        System.out.println(sb.toString());
    }
}