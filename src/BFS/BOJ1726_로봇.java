package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1726_로봇 {
    static int n, m;
    static int[][] map;
    static Node start, end;
    static int[] dr = {0, 0, 0, 1, -1};
    static int[] dc = {0, 1, -1, 0, 0};
    static int[][][] visit;
    static boolean[] dirFlag = new boolean[5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(br.readLine());
        end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        bfs();
        System.out.println(visit[end.x][end.y][end.dir]);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.x, start.y, start.dir, start.turn));
        visit = new int[n + 1][m + 1][5];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= 4; k++) {
                    visit[i][j][k] = 987654321;
                }
            }
        }
        visit[start.x][start.y][start.dir] = 0;
        while (!q.isEmpty()) {
            Node cnt = q.poll();
            if (cnt.x == end.x && cnt.y == end.y) {
                int tmp= 0;
                if (cnt.dir == 1 && end.dir == 2) {
                    tmp = visit[cnt.x][cnt.y][cnt.dir]+2;;
                } else if (cnt.dir == 2 && end.dir == 1) {
                    tmp = visit[cnt.x][cnt.y][cnt.dir]+2;
                } else if (cnt.dir == 3 && end.dir == 4) {
                    tmp = visit[cnt.x][cnt.y][cnt.dir]+2;
                } else if (cnt.dir == 4 && end.dir == 3) {
                    tmp = visit[cnt.x][cnt.y][cnt.dir]+2;
                } else if (cnt.dir == end.dir) {
                    tmp= visit[cnt.x][cnt.y][cnt.dir];
                } else {
                    tmp = visit[cnt.x][cnt.y][cnt.dir]+1;
                }
                visit[cnt.x][cnt.y][end.dir] =Math.min(tmp,visit[cnt.x][cnt.y][end.dir] );
            }
            Arrays.fill(dirFlag, false);
            for (int k = 1; k <= 3; k++) {
                for (int i = 1; i <= 4; i++) {
                    if (dirFlag[i]) continue;
                    int r = cnt.x + k * dr[i];
                    int c = cnt.y + k * dc[i];
                    if (r < 1 || c < 1 || r > n || c > m || map[r][c] == 1) {
                        dirFlag[i] = true;
                        continue;
                    }
                    int sameDir = 0;
                    if (cnt.dir == 1) {
                        if (i == 3 || i == 4) {
                            sameDir = 1;
                        } else if (i == 2) {
                            sameDir = 2;
                        } else {
                            sameDir = 0;
                        }
                    } else if (cnt.dir == 2) {
                        if (i == 3 || i == 4) {
                            sameDir = 1;
                        } else if (i == 1) {
                            sameDir = 2;
                        } else {
                            sameDir = 0;
                        }
                    } else if (cnt.dir == 3) {
                        if (i == 1 || i == 2) {
                            sameDir = 1;
                        } else if (i == 4) {
                            sameDir = 2;
                        } else {
                            sameDir = 0;
                        }
                    } else if (cnt.dir == 4) {
                        if (i == 1 || i == 2) {
                            sameDir = 1;
                        } else if (i == 3) {
                            sameDir = 2;
                        } else {
                            sameDir = 0;
                        }
                    }

                    if (visit[r][c][i] > cnt.turn + sameDir + 1) {
                        visit[r][c][i] = cnt.turn + sameDir + 1;
                        q.add(new Node(r, c, i, cnt.turn + sameDir + 1));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int dir;
        int turn;

        public Node(int x, int y, int dir, int turn) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.turn = turn;
        }
    }
}