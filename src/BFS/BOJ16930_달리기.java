package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16930_달리기 {
    static char[][] map;
    static int[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int res = 0;
    static int n, m, k;
    static int startX, startY, destX, destY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[n + 1][m + 1];
        visit = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str[j - 1];
                visit[i][j] = 987654321;
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        destX = Integer.parseInt(st.nextToken());
        destY = Integer.parseInt(st.nextToken());
        bfs();
        if (visit[destX][destY] == 987654321) res = -1;
        else res = visit[destX][destY];
        System.out.println(res);
    }


    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        visit[startX][startY] = 0;
        out:while (!q.isEmpty()) {
            int[] point = q.poll();
            int x=point[0];
            int y= point[1];

            for (int i = 0; i < 4; i++) {
                for (int klen = 1; klen <= k; klen++) {
                    int r = x + klen * dr[i];
                    int c = y + klen * dc[i];
                    if (r < 1 || c < 1 || r > n || c > m) break;
                    if(map[r][c]=='.'){
                        if(visit[r][c]==987654321){
                            visit[r][c]=visit[x][y]+1;
                            if(r==destX&&c==destY)break out;
                            q.add(new int[]{r, c});
                        }
                        else if (visit[r][c] <= visit[x][y]) {
                            break;
                        }
                    }else {
                        break;
                    }
                }
            }
        }
    }
}
