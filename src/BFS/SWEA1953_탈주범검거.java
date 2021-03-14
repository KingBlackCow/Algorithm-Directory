package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class SWEA1953_탈주범검거 {
    static int n, m, startX, startY, turn;
    static int[][] ary;
    static boolean[][] visit;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            turn = Integer.parseInt(st.nextToken());
            ary = new int[n][m];
            visit = new boolean[n][m];

            q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    ary[i][j] = Integer.parseInt(str[j]);
                }
            }
            bfs();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j]) {
                        sum++;
                    }
                }
            }

            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static void bfs() {
        q.add(new Node(startX, startY, ary[startY][startY]));
        int tmp = 1;
        visit[startX][startY] = true;

        while (!q.isEmpty()) {
            int qSize=q.size();
            if (tmp >= turn) return;
            for (int t = 0; t < qSize; t++) {
                Node node = q.poll();
                for (int i = 0; i < 4; i++) {
                    if (ary[node.x][node.y] == 2) {
                        if (i == 2 || i == 3) continue;
                    } else if (ary[node.x][node.y] == 3) {
                        if (i == 0 || i == 1) continue;
                    } else if (ary[node.x][node.y] == 4) {
                        if (i == 1 || i == 2) continue;
                    } else if (ary[node.x][node.y] == 5) {
                        if (i == 0 || i == 2) continue;
                    } else if (ary[node.x][node.y] == 6) {
                        if (i == 0 || i == 3) continue;
                    } else if (ary[node.x][node.y] == 7) {
                        if (i == 1 || i == 3) continue;
                    }
                    int r = node.x + dr[i];
                    int c = node.y + dc[i];

                    if (r < 0 || r >= n || c < 0 || c >= m) continue;
                    if (!visit[r][c] && ary[r][c] != 0) {
                        if(i==0){
                            if(ary[r][c]==3||ary[r][c]==4||ary[r][c]==7)continue;
                        }
                        else if(i==1){
                            if(ary[r][c]==3||ary[r][c]==5||ary[r][c]==6)continue;
                        }
                        else if(i==2){
                            if(ary[r][c]==2||ary[r][c]==6||ary[r][c]==7)continue;
                        }
                        else if(i==3){
                            if(ary[r][c]==2||ary[r][c]==4||ary[r][c]==5)continue;
                        }
                        q.add(new Node(r, c, ary[r][c]));
                        visit[r][c] = true;
                    }
                }
            }
            tmp++;

        }
    }


    static class Node {
        int x;
        int y;
        int dir;

        Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
