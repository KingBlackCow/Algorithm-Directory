package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16433_주디와당근농장 {
    static int n,r,c;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] ary;
    static boolean[][] visit;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
         n=Integer.parseInt(st.nextToken());
         r=Integer.parseInt(st.nextToken());
         c=Integer.parseInt(st.nextToken());
        ary=new char[n+1][n+1];
        visit=new boolean[n+1][n+1];
        ary[r][c]='v';
        bfs();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }

    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c, -1));
        visit[r][c]=true;
        while (!q.isEmpty()){
            Node tmp=q.poll();
            for (int i = 0; i < 4; i++) {
                int nx=tmp.x+dr[i];
                int ny=tmp.y+dc[i];
                if(nx<1||ny<1||nx>n||ny>n)continue;
                if(!visit[nx][ny]){
                    if(tmp.turn==1){
                        ary[nx][ny]='v';
                        visit[nx][ny]=true;
                        q.add(new Node(nx,ny,-1));
                    }else if(tmp.turn==-1){
                        ary[nx][ny]='.';
                        visit[nx][ny]=true;
                        q.add(new Node(nx,ny,1));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        int turn;
        public Node(int x, int y,int turn) {
            this.x = x;
            this.y = y;
            this.turn=turn;
        }
    }
}