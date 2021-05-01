package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16948_데스나이트 {

    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};
    static int n;
    static int startX, startY, destX, destY;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit=new boolean[n][n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        startX=Integer.parseInt(st.nextToken());
        startY=Integer.parseInt(st.nextToken());
        destX=Integer.parseInt(st.nextToken());
        destY=Integer.parseInt(st.nextToken());
        System.out.println(bfs());
    }

    private static int bfs() {
        visit[startX][startY]=true;
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(startX,startY));
        int turn = 0;
        while (!q.isEmpty()){
            int qSize= q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Point point =q.poll();
                if(point.x==destX&&point.y==destY){
                    return turn;
                }
                for (int i = 0; i < 6; i++) {
                    int r= point.x+dr[i];
                    int c= point.y+dc[i];
                    if(r<0||c<0||r>=n||c>=n)continue;
                    if(!visit[r][c]){
                        visit[r][c]=true;
                        q.add(new Point(r,c));
                    }
                }
            }
            turn++;
        }
        return -1;
    }
}