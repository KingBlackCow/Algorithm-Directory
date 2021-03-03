package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class BOJ13460_구슬탈출2 {
    static int n, m;
    static boolean visit[][][][];

    static String[][] ary;
    static int ans = -1;
    static int redX, redY, blueX, blueY, holeX, holeY;
    static int dir[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int dr[] = {1, 0, -1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new String[n][m];
        visit = new boolean[10][10][10][10];
        for (int i = 0; i < n; ++i) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; ++j) {
                ary[i][j]= str[j];
                if(ary[i][j].equals("O")){
                    holeX=i;
                    holeY=j;
                }else if(ary[i][j].equals("R")){
                    redX = i;
                    redY = j;
                }else if(ary[i][j].equals("B")){
                    blueX = i;
                    blueY = j;
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, redX, redY, blueX, blueY));
        visit[redX][redY][blueX][blueY] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.depth > 10)
                break;
            if (tmp.redX == holeX && tmp.redY == holeY) {
                ans = tmp.depth;
                break;
            }
            for (int i = 0; i < 4; ++i) {
                int rx = tmp.redX;
                int ry = tmp.redY;
                int bx = tmp.blueX;
                int by = tmp.blueY;
                int[] ary = move(rx, ry, i);
                rx = ary[0];
                ry = ary[1];
                ary = move(bx, by, i);
                bx = ary[0];
                by = ary[1];
                if (bx == holeX && by == holeY)
                    continue;

                if (rx == bx && ry == by) {
                    switch (i) {
                        case 0:
                            if (tmp.redX < tmp.blueX) {
                                rx--;
                            } else {
                                bx--;
                            }
                            break;
                        case 2:
                            if (tmp.redX < tmp.blueX) {
                                bx++;
                            } else {
                                rx++;
                            }
                            break;
                        case 1:
                            if (tmp.redY < tmp.blueY) {
                                ry--;
                            } else {
                                by--;
                            }
                            break;
                        case 3:
                            if (tmp.redY < tmp.blueY) {
                                by++;
                            } else {
                                ry++;
                            }
                            break;
                    }
                }
                if (!visit[rx][ry][bx][by]) {
                    q.add( new Node(tmp.depth + 1, rx, ry, bx, by));
                    visit[rx][ry][bx][by] = true;
                }
            }
        }
    }

    static int[] move(int x, int y, int d) {
        while (true) {
            x += dr[d];
            y += dc[d];
            if (ary[x][y].equals("#")) {
                x -= dr[d];
                y -= dc[d];
                break;
            } else if (ary[x][y].equals("O"))
                break;
        }
        return new int[]{x, y};
    }

    static class Node {
        int depth;
        int redX, redY, blueX, blueY;

        Node(int depth, int redX, int redY, int blueX, int blueY) {
            this.depth = depth;
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
        }
    }
}

