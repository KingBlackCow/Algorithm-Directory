package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16985_Maaaaaaaaaze {

    static int n, m;
    static int[][][] tmp;
    static int[][][] map;
    static int[][][] mapRotate;
    static int[][][] mapRotateTmp;
    static int[] arr;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static boolean[][][] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        tmp = new int[5][5][5];
        arr = new int[5];
        visit = new boolean[5][5][5];
        visited = new boolean[5];
        mapRotate = new int[5][5][5];
        mapRotateTmp = new int[5][5][5];
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    tmp[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }


        dfs(0);
        if(min==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void dfs(int x) {
        if (x == 5) {
            make();
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[x] = i;
                dfs(x + 1);
                visited[i] = false;
            }
        }
    }

    private static void make() {
        map = new int[5][5][5];
        for (int k = 0; k < 5; k++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[k][i][j] = tmp[arr[k]][i][j];
                }
            }
        }
        Backtracking(0, new int[5][5][5], map);

    }

    public static void Backtracking(int height, int[][][] nmap, int[][][] map) {
        if (height == 5) {        //배치한 판을 회전시킨 경우의 수마다 bfs
            if (nmap[0][0][0] == 1 && nmap[4][4][4] == 1) {
                int tmp = bfs(nmap);
                if (tmp != -1) min = Math.min(min, tmp);
            }
            return;
        }
        for (int cnt = 1; cnt <= 4; cnt++) {     //반시계 돌리는 횟수
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[height][i][j] == 1) {
                        switch (cnt) {
                            case 1:
                                nmap[height][j][4 - i] = 1;
                                break;
                            case 2:
                                nmap[height][4 - i][4 - j] = 1;
                                break;
                            case 3:
                                nmap[height][4 - j][i] = 1;
                                break;
                            case 4:
                                nmap[height][i][j] = 1;
                                break;
                        }
                    }
                }
            }
            Backtracking(height + 1, nmap, map);
            nmap[height] = new int[5][5];
        }
        return;
    }




    private static int bfs(int[][][] nmap) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        visit = new boolean[5][5][5];
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == 4 && tmp.y == 4 && tmp.z == 4) {
                return tmp.cnt;
            }
            for (int i = 0; i < 6; i++) {
                int nz = tmp.z + dz[i];
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if (nx < 0 || ny < 0 || nx > 4 || ny > 4 || nz < 0 || nz > 4) continue;
                if (!visit[nz][nx][ny] && nmap[nz][nx][ny] == 1) {
                    q.add(new Node(nz, nx, ny, tmp.cnt + 1));
                    visit[nz][nx][ny] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    static class Node {
        int z;
        int x;
        int y;
        int cnt;

        public Node(int z, int x, int y, int cnt) {
            this.z = z;
            this.x = x;
            this.y = y;

            this.cnt = cnt;
        }
    }
}