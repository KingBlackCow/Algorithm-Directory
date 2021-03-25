package FloydWarshall;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ1956_운동 {

    static final int INF = 9999999;
    static int n, m, ary[][];
    static int visit[];
    static boolean res;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n + 1][n + 1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i != j && ary[i][j] == 0) {
                    ary[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[a][b] = c;
        }

        for (int k = 1; k <= n; ++k) {
            for (int i = 1; i <= n; ++i) {
                if (i == k) continue;
                for (int j = 1; j <= n; ++j) {
                    if (i == j || k == j) continue;
                    if (ary[i][j] > ary[i][k] + ary[k][j]) {
                        ary[i][j] = ary[i][k] + ary[k][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (ary[i][j] == INF || ary[j][i] == INF) continue;
                min = Math.min(ary[i][j] + ary[j][i], min);
            }

        }
        if(min!=Integer.MAX_VALUE) {
            System.out.println(min);
        }else{
            System.out.println(-1);
        }

    }
}

