package 구현;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class BOJ11816_8진수10진수16진수 {
    static int n, m;
    static int[][] map;
    static List<Point> point = new ArrayList<>();
    static int[] ary;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int max = Integer.MAX_VALUE;
    static boolean[][] visit;
    static int count = 0, answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s=st.nextToken();

        if(s.charAt(0)=='0'){
            if(s.charAt(1)=='x') {
                String subS= s.substring(2);
                bw.write(Integer.parseInt(subS,16)+"\n");
            }else{
                bw.write(Integer.parseInt(s,8)+"\n");
            }

        }else{
            bw.write(Integer.parseInt(s)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }




}