package 문자열;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10823_더하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while (true) {
            String a = br.readLine();
            if (a == null) break;
            str += a;
        }
        StringTokenizer st = new StringTokenizer(str, ",");
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        System.out.println(sum);


        bw.flush();
        bw.close();
        br.close();
    }


}