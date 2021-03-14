package 누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11659_구간합구하기4 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ary[]=new int[n];
        int ary2[]=new int[n];

        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
            if(i!=0)ary2[i]+=ary2[i-1]+ary[i];
            else{
                ary2[i]=ary[i];
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int sum=0;
            int f=Integer.parseInt(st.nextToken())-1;
            int s=Integer.parseInt(st.nextToken())-1;
            if(f!=0){
                sum=ary2[s]-ary2[f-1];
            }else{
                sum=ary2[s];
            }

            sb.append(sum+"\n");
        }
        System.out.println(sb.toString());
    }
}

