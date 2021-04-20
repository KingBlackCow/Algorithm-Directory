package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16439_치킨치킨치킨 {
    static int n , m;
    static int[][] ary;
    static int[] select;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary=new int[n][m];
        select= new int[3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(max);
    }

    private static void dfs(int x, int cnt) {
        if(x==3){
            int sum =0;
            for (int i = 0; i < n; i++) {
                sum += Math.max(Math.max(ary[i][select[0]],ary[i][select[1]]),ary[i][select[2]]);
            }
            max=Math.max(sum,max);
            return;
        }
        for (int i = cnt; i < m; i++) {
            select[x]=i;
            dfs(x+1,i+1);
        }
    }
}
