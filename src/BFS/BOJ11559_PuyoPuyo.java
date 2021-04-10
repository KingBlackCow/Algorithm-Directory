package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11559_PuyoPuyo {

    static String[][] ary = new String[12][6];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean visit[][];
    static int visited[][];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < 6; j++) {
                ary[i][j] = str[j];
            }
        }
        int turn=0;
        while (true) {
            visit = new boolean[12][6];
            int ary2[][] = new int[12][6];
            boolean breakTmp=true;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (!ary[i][j].equals(".") && !visit[i][j]) {
                        visited = new int[12][6];
                        int cnt = bfs(i, j);
                        if (cnt >= 4) {
                            breakTmp=false;
                            for (int k = 0; k < 12; k++) {
                                for (int l = 0; l < 6; l++) {
                                    if (visited[k][l] != 0) {
                                        ary2[k][l] = cnt;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(breakTmp)break;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (ary2[i][j] != 0) {
                        ary[i][j] = ".";
                    }
                }
            }

            for (int i = 0; i < 6; i++) {
                Queue<String> q = new LinkedList<>();
                for (int j = 11; j >= 0; j--) {
                    if (!ary[j][i].equals(".")) {
                        q.add(ary[j][i]);
                    }
                }
                for (int j = 11; j >= 0; j--) {
                    if (!q.isEmpty()) {
                        ary[j][i] = q.poll();
                    } else {
                        ary[j][i] = ".";
                    }
                }
            }
            turn++;
        }
        System.out.println(turn);
        br.close();
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList();
        q.add(new Node(x, y));
        visit[x][y] = true;
        visited[x][y] = 1;
        int cnt = 0;
        String pivot = ary[x][y];
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= 12 || c >= 6) continue;
                if (!visit[r][c] && pivot.equals(ary[r][c])) {
                    visit[r][c] = true;
                    visited[r][c] = 1;
                    q.add(new Node(r, c));
                }
            }
        }
        return cnt;
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