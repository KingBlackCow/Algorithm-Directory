package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1100_하얀칸 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        String[] ary=new String[64];
        int cnt = 0;
        boolean flag=true;
        for (int i = 0; i < 8; i++) {
            String str[] =br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                ary[i*8+j] = str[j];
                if(flag){
                    if(ary[i*8+j].equals("F")){
                        cnt++;
                    }
                }
                flag=!flag;
            }
            flag=!flag;
        }
        System.out.println(cnt);

    }
}
