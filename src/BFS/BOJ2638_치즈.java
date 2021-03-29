package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2638_치즈 {

    static int n, m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] ary;
    static int[][] map;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];

        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int turn=0;
        while (true) {
            visit = new boolean[n][m];
            if(!bfs())break;
            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j]) {
                        map[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int r = i + dr[k];
                            int c = j + dc[k];
                            if (r < 0 || c < 0 || r >= n || c >= m) {
                                cnt++;
                                continue;
                            }
                            if (map[r][c] == 0) {
                                cnt++;
                            }
                        }
                        if (cnt >= 2) {
                            map[i][j] = 2;
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        ary[i][j] = 0;
                    }
                }
            }
            turn++;
        }
        System.out.println(turn);
    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visit[0][0]=true;
        boolean breaking=false;
        while (!q.isEmpty()){
            Node tmp=q.poll();
            for (int i = 0; i < 4; i++) {
                int r=tmp.x+dr[i];
                int c=tmp.y+dc[i];
                if(r<0||c<0||r>=n||c>=m)continue;
                if(!visit[r][c]&&ary[r][c]==0){
                    q.add(new Node(r,c));
                    visit[r][c]=true;
                }
                if(ary[r][c]==1){
                    breaking=true;
                }
            }
        }
        return breaking;
    }


    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
