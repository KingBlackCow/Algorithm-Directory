package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1405_미친로봇 {

    static int n, m;
    static char[][] ary;
    static char[][] arr;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] dir= new int[4];
    static double res = 0;
    static boolean[][] visit=new boolean[31][31];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            dir[i]=Integer.parseInt(st.nextToken());
        }
        dfs(15,15 ,0,1.0);
        System.out.println(String.format("%.10f", res));

    }
    private static void dfs(int x, int y, int cnt,double posibble) {
        visit[x][y]=true;
        if(cnt==n){
            res+=posibble;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r=x+dr[i];
            int c=y+dc[i];
            if(!visit[r][c]){
                visit[r][c]=true;
                dfs(r,c,cnt+1, posibble*0.01*dir[i]);
                visit[r][c]=false;
            }
        }
    }


}