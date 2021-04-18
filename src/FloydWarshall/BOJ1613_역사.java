package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1613_역사 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int inf = 987654321;
        int[][] ary = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) ary[i][j] = 0;
                else ary[i][j] = inf;
            }
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ary[f][s] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ary[i][j] = Math.min(ary[i][k] + ary[k][j], ary[i][j]);
                }
            }
        }
        int order = Integer.parseInt(br.readLine());
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (ary[f][s] != inf && ary[s][f] == inf) {
                System.out.println(-1);
            } else if (ary[f][s] == inf && ary[s][f] != inf) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        bw.close();
        br.close();
    }


}