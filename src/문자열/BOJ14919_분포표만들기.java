package 문자열;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ14919_분포표만들기 {
    static double n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        int[] range = new int[(int) n];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            double cnt = Double.parseDouble(st.nextToken());
            int count = 1;
            while (true) {
                double pivot = count / n;
                if (cnt < pivot) {
                    range[count - 1]++;
                    break;
                }
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(range[i]+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }


}