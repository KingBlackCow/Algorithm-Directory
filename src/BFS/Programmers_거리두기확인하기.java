package BFS;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Programmers_거리두기확인하기 {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        int cnt = 0;
        for(int i = 0; i < places.length; i++){
            map = new char[5][5];
            for(int j = 0 ; j<places[i].length;j++){
                map[j] = places[i][j].toCharArray();
            }
            boolean flag = true;
            out: for(int a= 0; a<5; a++){
                for(int b= 0; b<5; b++){
                    if(map[a][b] == 'P'){
                        if(!bfs(a,b)){
                            flag = false;
                            break out;
                        }
                    }
                }
            }
            answer[cnt++] = flag? 1:0;
        }


        return answer;
    }

    static boolean bfs( int startA, int startB){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startA,startB));
        boolean[][] visit = new boolean[5][5];
        visit[startA][startB]=true;
        int turn = 0;
        while(!q.isEmpty()&& turn<2){
            Point point = q.poll();

            for(int i = 0; i<4; i++){
                int r = point.x + dr[i];
                int c = point.y + dc[i];
                if(r<0||c<0||r>=5||c>=5)continue;
                if(visit[r][c])continue;
                if(map[r][c]=='P')return false;
                if(map[r][c] =='O'){
                    visit[r][c] = true;
                    q.add(new Point(r,c));
                }
            }
            turn++;
        }
        return true;
    }
}