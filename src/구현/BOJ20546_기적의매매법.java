package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546_기적의매매법 {
    static int n;
    static int[] ary;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ary=new int[14];
        int one = n;
        int two = n;
        int oneNum = 0;
        int twoNum = 0;
        int asc = 0, desc = 0;
        int sum1 = 0, sum2 = 0;
        st = new StringTokenizer(br.readLine());

        ary[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < 14; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
            if (ary[i - 1] < ary[i]) {
                desc = 0;
                asc++;
            } else if (ary[i - 1] > ary[i]) {
                asc = 0;
                desc++;
            } else {
                asc = 0;
                desc = 0;
            }
            if (desc >= 3) {
                twoNum += two / ary[i];
                two -= two / ary[i] * ary[i];
            }
            if (asc >= 3) {
                two += twoNum * ary[i];
                twoNum = 0;
            }
        }

        for (int i = 0; i < 14; i++) {
            if (one >= ary[i]) {
                oneNum += one / ary[i];
                one -= one / ary[i] * ary[i];
            }
        }
        sum1 = one+ary[13]*oneNum;
        sum2 = two + ary[13]*twoNum;
        if(sum1>sum2){
            System.out.println("BNP");
        }else if(sum1<sum2){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
    }
}
