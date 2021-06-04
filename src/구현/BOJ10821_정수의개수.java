package 구현;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ10821_정수의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(),",");
        bw.write(st.countTokens()+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}