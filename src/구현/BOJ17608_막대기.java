package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n =Integer.parseInt(br.readLine());
        int[] ary= new int[n];
        for (int i = 0; i < n; i++) {
            ary[i]=Integer.parseInt(br.readLine());
        }
        int pivot =0;
        for (int i = n-1; i >=0 ; i--) {
            if(pivot<ary[i]){
                pivot=ary[i];
                sum++;
            }
        }
        System.out.println(sum);
    }

}