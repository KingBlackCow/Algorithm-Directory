package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA5656_벽돌깨기 {

    static int n, w, h;
    static int min;
    static int[][] ary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            ary = new int[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    ary[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int copy[][] = new int[w][h];
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    copy[i][j] = ary[i][j];
                }
            }
            min = Integer.MAX_VALUE;
            dfs(copy, 0);
            sb.append("#" + tc + " " + min + "\n");
        }
        System.out.println(sb.toString());

    }

    private static void dfs(int[][] map, int turn) {
        if (turn == n) {
            int cnt = 0;
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] != 0) {
                        cnt++;
                    }
                }
            }
            min = Math.min(cnt, min);
            return;
        }
        int copy[][] = new int[w][h];

        for (int i = 0; i < h; i++) {
            for (int k = 0; k < w; k++) {
                for (int j = 0; j < h; j++) {
                    copy[k][j] = map[k][j];
                }
            }
            int[][] map2 = shot(copy, i);
            dfs(map2, turn + 1);
        }
    }

    private static int[][] shot(int[][] map, int m) {
        int high = 0;
        while (high < w) {
            if (map[high][m] != 0) {
                break;
            }
            high++;
        }
        Queue<Node> q=new LinkedList<>();
        boolean[][] visit=new boolean[w][h];
        if(high<w){
            q.add(new Node(high,m));
            visit[high][m]=true;
        }
        while (!q.isEmpty()) {
            Node tmp=q.poll();
            int weight=map[tmp.x][tmp.y]-1;
            for (int i = -weight; i <= weight; i++) {
                int r=tmp.x+i;
                if(r<0||r>=w)continue;
                if(!visit[r][tmp.y]){
                    visit[r][tmp.y]=true;
                    q.add(new Node(tmp.x+i,tmp.y));
                }

            }
            for (int i = -weight; i <= weight; i++) {
                int c=tmp.y+i;
                if(c<0||c>=h)continue;
                if(!visit[tmp.x][c]){
                    visit[tmp.x][c]=true;
                    q.add(new Node(tmp.x,c));
                }

            }

        }
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if(visit[i][j]){
                    map[i][j]=0;
                }
            }
        }
        down(map);
        return map;
    }

    private static void down(int[][] map) {

        for (int j = 0; j < h; j++) {
            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i < w; i++) {
                if(map[i][j]!=0){
                    stack.add(map[i][j]);
                }
            }
            for (int i = w-1; i >=0; i--) {
                if(!stack.isEmpty()){
                    map[i][j]=stack.pop();
                }else{
                    map[i][j]=0;
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
