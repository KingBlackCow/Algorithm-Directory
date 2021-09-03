package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5427_불 {
    static int n, m;
    static char[][] map;
    static Point person, fire;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visit;
    static Queue<Point> fireQ = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            fireQ.clear();
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '@') {
                        person = new Point(i, j);
                    } else if (map[i][j] == '*') {
                        fire = new Point(i, j);
                        fireQ.add(fire);
                    }
                }
            }
            int flag= bfs();
            if(flag==-1){
                sb.append("IMPOSSIBLE"+"\n");
            }else{
                sb.append(flag+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(person);
        visit = new boolean[n][m];
        visit[person.x][person.y] = true;
        int turn = 0;
        boolean success = false;
        out:while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Point cnt = q.poll();
                if(map[cnt.x][cnt.y]=='*')continue;
                if(cnt.x==0||cnt.x==n-1||cnt.y ==0||cnt.y==m-1){
                    success=true;
                    break out;
                }
                for (int i = 0; i < 4; i++) {
                    int r = cnt.x + dr[i];
                    int c = cnt.y + dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if ( map[r][c] == '.') {
                        map[r][c] = '@';
                        q.add(new Point(r, c));
                    }
                }
            }

            int fireQSize = fireQ.size();
            for (int qlen = 0; qlen < fireQSize; qlen++) {
                Point fire = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int r = fire.x + dr[i];
                    int c = fire.y + dc[i];
                    if (r < 0 || c < 0 || r >= n || c >= m) continue;
                    if (map[r][c] == '.'||map[r][c]=='@') {
                        fireQ.add(new Point(r, c));
                        map[r][c] = '*';
                    }
                }
            }
            turn++;
        }
        if(success){
            return turn+1;
        }else{
            return -1;
        }
    }
}