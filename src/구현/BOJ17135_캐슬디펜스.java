package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17135_캐슬디펜스 {

    static int[][] ary;
    static int n, m, D;
    static boolean[][] visited;
    static int res = 0;
    static List<Integer> arrowMan;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arrowMan = new ArrayList<>();
        dfs(0, 0);

        bw.write(max + "\n");
        bw.close();
        br.close();
    }

    private static void dfs(int x, int cnt) {
        if (x == 3) {
            res = 0;
            int[][] ary2=init();
            attack(ary2);
            max = Math.max(max, res);
            return;
        }
        for (int i = cnt; i < m; i++) {
            arrowMan.add(i);
            dfs(x + 1, i + 1);
            arrowMan.remove(arrowMan.size() - 1);
        }
    }

    private static int[][] init() {
        int ary2[][]=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ary2[i][j]=ary[i][j];
            }
        }
        return ary2;
    }


    private static void attack(int[][] ary2) {
        for (int turn = 0; turn < n; turn++) {
            visited=new boolean[n][m];

            for (int i = 0; i < arrowMan.size(); i++) {
                int arrowX = n;
                int arrowY = arrowMan.get(i);
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;
                int minDistance = Integer.MAX_VALUE;
                for (int j = n-1; j >= 0; j--) {
                    for (int k = 0; k < m; k++) {
                        if (ary2[j][k] == 1) {
                            if (minDistance > distance(arrowX, j, arrowY, k)) {
                                minDistance = distance(arrowX, j, arrowY, k);
                                minX = j;
                                minY = k;
                            }else if(minDistance == distance(arrowX, j, arrowY, k)){
                                if (minY > k) {
                                    minX = j;
                                    minY = k;
                                }
                            }
                        }
                    }
                }
                if (minDistance <= D) {
                    visited[minX][minY] = true;
                }

            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (visited[j][k]) {
                        ary2[j][k] = 0;
                        res++;
                    }
                }
            }
            mapDown(ary2);
        }
    }

    private static void mapDown(int[][] ary2) {
        int copyAry[][] = new int[n][m];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                copyAry[i + 1][j] = ary2[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            copyAry[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ary2[i][j]=copyAry[i][j];
            }
        }
    }

    public static int distance(int r1, int r2, int c1, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
