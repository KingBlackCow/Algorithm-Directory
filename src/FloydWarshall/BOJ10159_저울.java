package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ10159_저울 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;


    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int INF = 9;
        int[][] ary = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) ary[i][j]=0;
                else ary[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            ary[s][f] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ary[i][j] = Math.min(ary[i][k] + ary[k][j], ary[i][j]);
                }
            }
        }
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(ary[i][j]!=INF || ary[j][i]!=INF){
                    cnt++;
                }
            }
            int res = n - cnt ;
            System.out.println(res);
        }
        bw.close();
        br.close();
    }


}