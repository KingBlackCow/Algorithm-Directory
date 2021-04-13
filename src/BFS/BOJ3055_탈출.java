package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class BOJ3055_탈출 {
    static int n;
    static int m;
    static int[][] visit;
    static int min = Integer.MAX_VALUE;
    static String ary[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int endX, endY;
    static int startX, startY;
    static int waterX, waterY;
    static Queue<Node> q;
    static Queue<Node> qWater;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new String[n][m];
        visit = new int[n][m];
        startX = 0;
        startY = 0;
        endX = 0;
        endY = 0;
        q = new LinkedList<>();
        qWater = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = str[j];
                if (ary[i][j].equals("S")) {
                    startX = i;
                    startY = j;
                }
                if (ary[i][j].equals("D")) {
                    endX = i;
                    endY = j;
                }
                if (ary[i][j].equals("*")) {
                    qWater.add(new Node(i, j, 0));
                }
            }
        }
        bfs();
        if (min == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(min);

    }

    private static void bfs() {
        q.add(new Node(startX, startY, 0));
        visit[startX][startY] = 1;

        while (!q.isEmpty()) {
            List<Node> list = new ArrayList<>();
            List<Node> list2 = new ArrayList<>();
            while (!qWater.isEmpty()) {
                Node tmpWater = qWater.poll();
                int x = tmpWater.x;
                int y = tmpWater.y;
                for (int i = 0; i < 4; i++) {
                    int r = x + dx[i];
                    int c = y + dy[i];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        if (visit[r][c] != -1) {
                            if (ary[r][c].equals(".")) {
                                list.add(new Node(r, c, 0));
                                visit[r][c] = -1;
                            }
                        }
                    }
                }
            }

            while (!q.isEmpty()) {
                Node tmp = q.poll();
                int goX = tmp.x;
                int goY = tmp.y;
                if (goX == endX && goY == endY) {
                    min = tmp.cnt;
                }

                for (int i = 0; i < 4; i++) {
                    int r = goX + dx[i];
                    int c = goY + dy[i];
                    if (r >= 0 && c >= 0 && r < n && c < m) {
                        if (visit[r][c] == 0) {
                            if (ary[r][c].equals(".") || ary[r][c].equals("D")) {
                                list2.add(new Node(r, c, tmp.cnt + 1));
                                visit[r][c] = 1;
                            }
                        }
                    }
                }
            }
            for (Node node : list) {
                qWater.add(new Node(node.x, node.y, 0));
            }
            for (Node node : list2) {
                q.add(new Node(node.x, node.y, node.cnt));
            }
        }


    }

    static class Node {
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }


    }

}


