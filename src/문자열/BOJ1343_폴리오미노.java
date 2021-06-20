package 문자열;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str=br.readLine();


        while (str.contains("XXXX")){
            str=str.replaceAll("XXXX","AAAA");
        }
        while (str.contains("XX")){
            str=str.replaceAll("XX","BB");
        }
        if(str.contains("X")){
            System.out.println(-1);
            System.exit(0);
        }
        bw.write(str+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}