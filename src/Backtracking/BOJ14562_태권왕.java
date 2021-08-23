package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14562_태권왕 {
    static int T;
    static int a,b;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (T-- >0){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans =Integer.MAX_VALUE;
            search(a,b,0);
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void search(int x, int y, int turn) {
        if(x>y)return;
        if(x==y){
            ans = Math.min(ans,turn);
            return;
        }
        search(x+x,y+3,turn+1);
        search(x+1,y,turn +1);
    }
}

