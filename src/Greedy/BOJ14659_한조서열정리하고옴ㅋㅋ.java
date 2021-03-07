package Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14659_한조서열정리하고옴ㅋㅋ {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int ary[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(st.nextToken());
        }
        int ans=0;
        int tmp=0;
        for (int i = 0; i < n; i++) {
            tmp=0;
            for (int j = i+1; j < n; j++) {
                if(ary[i]>ary[j]){
                    tmp++;
                }else{
                    break;
                }
            }
            ans=Math.max(tmp,ans);

        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }





}
