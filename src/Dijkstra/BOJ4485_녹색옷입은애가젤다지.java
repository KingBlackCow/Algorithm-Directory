package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {

    static int n;
    static int[][] map;
    static int[][] D;
    static int[] dy = {0, 1, -1, 0};
    static int[] dx = {1, 0, 0, -1};

    public static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, map[0][0]));
        D[0][0]=map[0][0];
        while (!pq.isEmpty()) {
            Node tmp = pq.poll();
            for (int i = 0; i < 4; i++) {
                int r = tmp.r + dx[i];
                int c = tmp.c + dy[i];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;
                if (D[r][c] > D[tmp.r][tmp.c] + map[r][c]) {
                    D[r][c] = D[tmp.r][tmp.c] + map[r][c];
                    pq.add(new Node(r, c, D[r][c]));
                }
            }
        }
        return D[n -1][n -1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int turn = 0;
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;
            map = new int[n][n];
            D = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
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

}