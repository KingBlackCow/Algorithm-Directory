package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1949_등산로조성 {
    static int n, k;
    static int[][] ary;
    static boolean[][] visit;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    static int max;
    static int maxTmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ary = new int[n][n];
            visit = new boolean[n][n];
            max = Integer.MIN_VALUE;
            maxTmp=0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    ary[i][j] = Integer.parseInt(str[j]);
                    max = Math.max(max, ary[i][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ary[i][j] == max) {
                        visit = new boolean[n][n];
                        visit[i][j]=true;
                        dfs(i, j, ary, true, 1);
                    }
                }
            }


            sb.append("#" + tc + " " + maxTmp + "\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static void dfs(int a, int b, int[][] ary, boolean first, int distance) {

        maxTmp=Math.max(distance,maxTmp);
        for (int l = 0; l < 4; l++) {
            int r = a + dr[l];
            int c = b + dc[l];
            if (r < 0 || r >= n || c < 0 || c >= n) continue;
            if (!visit[r][c]) {
                if (ary[r][c] < ary[a][b]) {
                    visit[r][c]=true;
                    dfs(r, c, ary, first,distance+1);
                    visit[r][c]=false;
                }else{
                    if (first) {
                        int tmpK=k;
                        int cnt=0;
                        while (ary[a][b]<=ary[r][c]){
                            if(tmpK>0){
                                tmpK--;
                                ary[r][c]--;
                                cnt++;
                            }else{
                                break;
                            }
                        }
                        if(ary[r][c]<ary[a][b]){
                            visit[r][c]=true;
                            dfs(r, c, ary,false,distance+1);
                            visit[r][c]=false;
                        }
                        for (int i = 0; i < cnt; i++) {
                            ary[r][c]++;
                        }
                    }
                }
            }
        }

    }
}
