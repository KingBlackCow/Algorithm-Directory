package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {


    static class Node implements Comparable<Node> {

        int r, c, weight;

        public Node(int row, int col, int cost) {

            this.r = row;
            this.c = col;
            this.weight = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

    }

    static int N;
    static int[][] map;
    static int[][] D;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};

    // 범위 검사
    static boolean isValid(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        D[0][0]=map[0][0];
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            for (int i = 0; i < 4; i++) {
                int r = tmp.r + dx[i];
                int c = tmp.c + dy[i];
                if (r < 0 || c < 0 || r >= N || c >= N) continue;
                if (D[r][c] > D[tmp.r][tmp.c] + map[r][c]) {
                    D[r][c] = D[tmp.r][tmp.c] + map[r][c];
                    pq.add(new Node(r, c, D[r][c]));
                }
            }
        }
        return D[N-1][N-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int turn = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            D = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    D[i][j] = Integer.MAX_VALUE;
                }

            }
            turn++;
            sb.append("Problem " + turn + ": " + dijkstra() + "\n");
        }
        System.out.println(sb);
        br.close();
    }

}