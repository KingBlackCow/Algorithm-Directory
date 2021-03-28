package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9376_탈옥 {


    static int n, m, x1, y1, x2, y2;
    static String[][] ary;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] door;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ary = new String[n + 2][m + 2];
            door = new int[n + 2][m + 2];
            for (int i = 0; i < n+2; i++) {
                for (int j = 0; j < m+2; j++) {
                    ary[i][j]=".";
                }
            }
            boolean flag = false;
            for (int i = 1; i <= n; ++i) {
                String[] tmp = br.readLine().split("");
                for (int j = 1; j <= m; ++j) {
                    ary[i][j] = tmp[j - 1];
                    if (ary[i][j].equals("$")) {
                        if (!flag) {
                            x1 = i;
                            y1 = j;
                            flag = true;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                    }
                }
            }


            if (findPersonFirst()) {
                sb.append(0 + "\n");
            } else {
                for (int i = 0; i < 3; ++i) {
                    bfs(i);
                }
                sb.append(getSum() + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int getSum() {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j < m + 1; ++j) {
                if (ary[i][j].equals("#")) min = Math.min(min, door[i][j]);
            }
        }
        return min - 2;
    }

    private static boolean findPersonFirst() {
        Queue<Node> q = new LinkedList<>();
        visit = new boolean[n + 2][m + 2];
        q.add(new Node(0, 0, 0));
        visit[0][0] = true;

        int cnt = 0;

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int i = 0; i < 4; ++i) {
                int r = tmp.r + dr[i];
                int c = tmp.c + dc[i];

                if (r < 0 || r >= n + 2 || c < 0 || c >= m + 2) continue;
                if (visit[r][c]) continue;
                if (ary[r][c].equals("*") || ary[r][c].equals("#")) continue;

                visit[r][c] = true;
                if (ary[r][c].equals("$")) cnt++;
                q.add(new Node(r, c, 0));
            }
        }
        if (cnt == 2) return true;
        else return false;

    }

    private static void bfs(int i) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        visit = new boolean[n + 2][m + 2];

        if (i == 0) {
            q.add(new Node(0, 0, 0));
            visit[0][0] = true;
        } else if (i == 1) {
            q.add(new Node(x1, y1, 0));
            visit[x1][y1] = true;
        } else if (i == 2) {
            q.add(new Node(x2, y2, 0));
            visit[x2][y2] = true;
        }

        while (!q.isEmpty()) {
            Node tmp = q.poll();

            for (int j = 0; j < 4; ++j) {
                int r = tmp.r + dr[j];
                int c = tmp.c + dc[j];

                if (r < 0 || r >= n + 2 || c < 0 || c >= m + 2) continue;
                if (visit[r][c] || ary[r][c].equals("*")) continue;

                visit[r][c] = true;

                if (ary[r][c].equals("#")) {
                    door[r][c] += tmp.cnt + 1;
                    q.add(new Node(r, c, tmp.cnt + 1));
                } else {
                    q.add(new Node(r, c, tmp.cnt));
                }

            }
        }
    }

    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int cnt;

        private Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}