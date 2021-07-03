package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16924_십자가찾기 {
    static int n, m;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }
        visit=new boolean[n+1][m+1];
        int conut = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == '*') {
                    int a = check(i, j);
                    if(a>0){
                        visit[i][j]=true;
                    }
                    while (a-- > 0) {
                        conut++;
                        int res = a + 1;
                        sb.append(i + " " + j + " " + res + "\n");
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j]=='*'&&!visit[i][j]){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        if(conut==0){
            System.out.println(-1);
            System.exit(0);
        }
        sb.insert(0,conut+"\n");
        System.out.println(sb.toString());
    }

    private static int check(int x, int y) {
        int turn = 1;

        out:
        while (true) {
            for (int i = 0; i < 4; i++) {
                int r = x + turn * dr[i];
                int c = y + turn * dc[i];
                if (r < 1 || c < 1 || r > n || c > m) break out;
                if (map[r][c] != '*') {
                    break out;
                }
            }
            for (int i = 0; i < 4; i++) {
                int r = x + turn * dr[i];
                int c = y + turn * dc[i];
                visit[r][c]=true;
            }
            turn++;
        }
        return turn - 1;
    }
}


