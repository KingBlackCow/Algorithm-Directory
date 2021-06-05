package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2525_오븐시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int hour=Integer.parseInt(st.nextToken());
        int min= Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(br.readLine());
        min+=s%60;
        hour+=s/60;
        if(min>=60){
            hour++;
            min-=60;
        }
        if(hour>=24){
            hour-=24;
        }
        System.out.println(hour+" "+min);
    }
}
