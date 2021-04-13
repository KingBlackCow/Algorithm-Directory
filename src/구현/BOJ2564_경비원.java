package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2564_경비원 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int ary[] = new int[n+1];
        int doole = garo*2+sero*2;
        for (int i = 0; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if (order == 1) {
                ary[i] = distance;
            } else if (order == 2) {
                ary[i] = garo + sero + (garo - distance);
            } else if (order == 3) {
                ary[i] = 2 * garo + sero + (sero - distance);
            } else if (order == 4) {
                ary[i] = garo +  distance;
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            int dist= Math.abs(ary[n]-ary[i]);
            sum+= Math.min(dist,doole-dist);
        }
        System.out.println(sum);
        bw.close();
        br.close();
    }
}