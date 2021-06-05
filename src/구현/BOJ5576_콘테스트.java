package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5576_콘테스트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int[] ary=new int[10];
        int[] ary2=new int[10];
        for (int i = 0; i < 20; i++) {
            if(i<10){
                ary[i]=Integer.parseInt(br.readLine());
            }else{
                ary2[i-10]=Integer.parseInt(br.readLine());
            }
        }
        Arrays.sort(ary);
        Arrays.sort(ary2);
        int sum =ary[7]+ary[8]+ary[9];
        int sum1 =ary2[7]+ary2[8]+ary2[9];
        System.out.println(sum+" "+sum1);
    }
}
