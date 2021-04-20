package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5212_지구온난화 {
    static int n, m;
    static String[][] ary;
    static int[] select;
    static int max = Integer.MIN_VALUE;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Node> q = new LinkedList<>();
    static Queue<Node> deadQ = new LinkedList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                ary[i][j] = str[j];
                if (ary[i][j].equals("X")) {
                    q.add(new Node(i, j));
                }
            }
        }

        bfs();
        int[] cut=cutMap();

        for (int i = cut[0]; i <= cut[1]; i++) {
            for (int j = cut[2]; j <= cut[3]; j++) {
                System.out.print(ary[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] cutMap() {
        int xStart=0,xEnd=n,yStart=0,yEnd=m;
        out:for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(ary[i][j].equals("X")){
                    xStart=i;
                    break out;
                }
            }
        }
        out:for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if(ary[i][j].equals("X")){
                    xEnd=i;
                    break out;
                }
            }
        }
        out:for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(ary[j][i].equals("X")){
                    yStart=i;
                    break out;
                }
            }
        }
        out:for (int i = m-1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if(ary[j][i].equals("X")){
                    yEnd=i;
                    break out;
                }
            }
        }
        return new int[]{xStart,xEnd,yStart,yEnd};
    }

    private static void bfs() {
        deadQ=new LinkedList<>();
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) {
                    sum++;
                    continue;
                }
                if (ary[r][c].equals(".")) {
                    sum++;
                }
            }
            if (sum >= 3) {
                deadQ.add(new Node(tmp.x,tmp.y));
            }
        }

        while (!deadQ.isEmpty()){
            Node tmp=deadQ.poll();
            ary[tmp.x][tmp.y]=".";
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
