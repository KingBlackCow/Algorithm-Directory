package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2947_나무조각 {
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ary = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            ary[i] =Integer.parseInt(st.nextToken());
        }
        boolean flag =true;
        while (flag) {
            for (int i = 0; i < 4; i++) {
                if (ary[i] > ary[i + 1]) {
                    int tmp = ary[i + 1];
                    ary[i + 1] = ary[i];
                    ary[i] = tmp;
                    for (int j = 0; j < 5; j++) {
                        System.out.print(ary[j] + " ");
                    }
                    System.out.println();
                }
            }
            if(ary[0]==1&&ary[1]==2&&ary[2]==3&&ary[3]==4&&ary[4]==5){
                flag=false;
            }
        }
        
    }
}