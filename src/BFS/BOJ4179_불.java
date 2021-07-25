package BFS;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_불 {
    static int n, m, turn;
    static char[][] ary;
    static int startX,startY;
    static Queue<Point> fireList =new LinkedList<>();
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static boolean[][] visit;
    static boolean[][] visitFire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary= new char[n][m];
        for (int i = 0; i < n; i++) {
            ary[i]=br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if(ary[i][j]=='J'){
                    startX=i;
                    startY=j;
                }else if(ary[i][j]=='F'){
                    fireList.add(new Point(i,j));
                }
            }
        }
        visitFire=new boolean[n][m];
        int res=bfs();
        if(res==-1){
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println(res);

        }
    }

    private static int bfs() {
        Queue<Point> q=new LinkedList<>();
        q.add(new Point(startX,startY));
        visit=new boolean[n][m];
        int turn = 0;
        while (!q.isEmpty()){
            int qSize=q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Point point = q.poll();
                if (ary[point.x][point.y] == 'F') continue;
                if (point.x==0||point.y==0||point.x == n - 1 || point.y == m - 1) return turn + 1;
                for (int i = 0; i < 4; i++) {
                    int r = point.x + dr[i];
                    int c = point.y + dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (!visit[r][c] && ary[r][c] == '.') {
                        q.add(new Point(r, c));
                        visit[r][c] = true;
                    }
                }
            }
            fireBfs();
            turn++;
        }
        return -1;
    }

    private static void fireBfs() {
        int fireListSize = fireList.size();
        for(int firelen= 0;firelen<fireListSize;firelen++){
            Point fire =fireList.poll();
            for (int i = 0; i < 4; i++) {
                int r =fire.x+dr[i];
                int c =fire.y+dc[i];
                if(r<0||c<0||r>=n||c>=m)continue;
                if(!visitFire[r][c] && ary[r][c]!='#'){
                    ary[r][c]='F';
                    fireList.add(new Point(r,c));
                    visitFire[r][c]=true;
                }
            }
        }
    }


}