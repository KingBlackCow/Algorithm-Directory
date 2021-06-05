package 문자열;

import java.io.*;

public class BOJ14916_거스름돈 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        int fiveNum = n / 5;
        int twoNum = n / 2;
        boolean success=false;
        if(n%5==0){
            System.out.println(fiveNum);
            System.exit(0);
        }
        for (int i = fiveNum; i >=1; i--) {
            int tmp= n-(i*5);
            for (int j = 1; j <= twoNum; j++) {
                int tmp2=tmp-2*j;
                if(tmp2==0){
                    System.out.println(i+j);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);

        bw.flush();
        bw.close();
        br.close();
    }


}
