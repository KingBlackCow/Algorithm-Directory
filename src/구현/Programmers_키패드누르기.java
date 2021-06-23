package 구현;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

class Programmers_키패드누르기 {
    static int[][] ary= {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-2}
    };
    static int[] dr={-1,1,0,0};
    static int[] dc={0,0,-1,1};
    static Point left= new Point(3,0);
    static Point right = new Point(3,2);
    public String solution(int[] numbers, String hand) {
        String answer = "";


        for(int i = 0; i<numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                if(numbers[i]==1){
                    left = new Point(0,0);
                }else if(numbers[i]==4){
                    left = new Point(1,0);
                }else if(numbers[i]==7){
                    left = new Point(2,0);
                }
                answer+="L";
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                if(numbers[i]==3){
                    right = new Point(0,2);
                }else if(numbers[i]==6){
                    right = new Point(1,2);
                }else if(numbers[i]==9){
                    right = new Point(2,2);
                }
                answer+="R";
            }else{
                answer+=getDistance( numbers[i], hand);
            }
        }
        return answer;
    }
    static String getDistance(int dest,String hand){
        Queue<Point> q= new LinkedList<>();
        q.add(left);
        boolean[][] visit= new boolean[4][3];
        visit[left.x][left.y]=true;
        int turn =0;
        int leftlen = 0;
        int rightlen = 0;
        Point tmpLeft= new Point(0,0);
        Point tmpRight= new Point(0,0);
        out:while(!q.isEmpty()){
            int qSize= q.size();
            for(int i = 0; i < qSize;i++){
                Point point = q.poll();
                if(ary[point.x][point.y] == dest){
                    leftlen=turn;
                    tmpLeft= new Point(point.x,point.y);
                    break out;
                }
                for(int j = 0; j < 4; j++){
                    int r= point.x+dr[j];
                    int c = point.y+dc[j];
                    if(r<0||c<0||r>=4||c>=3)continue;
                    if(!visit[r][c]){
                        visit[r][c]=true;
                        q.add(new Point(r,c));
                    }
                }
            }
            turn++;
        }
        q.clear();
        q.add(right);
        visit= new boolean[4][3];
        visit[right.x][right.y]=true;
        turn = 0;
        out:while(!q.isEmpty()){
            int qSize= q.size();
            for(int i = 0; i<qSize;i++){
                Point point = q.poll();
                if(ary[point.x][point.y] == dest){
                    rightlen=turn;
                    tmpRight = new Point(point.x,point.y);
                    break out;
                }
                for(int j = 0; j < 4; j++){
                    int r = point.x+dr[j];
                    int c = point.y+dc[j];
                    if(r<0||c<0||r>=4||c>=3)continue;
                    if(!visit[r][c]){
                        visit[r][c]=true;
                        q.add(new Point(r,c));
                    }
                }
            }
            turn++;
        }
        if(leftlen < rightlen){
            left = tmpLeft;
            return "L";
        }else if(leftlen > rightlen){
            right = tmpRight;
            return "R";
        }else{
            if(hand.equals("left")){
                left = tmpLeft;
                return "L";
            }else{
                right = tmpRight;
                return "R";
            }
        }
    }
}