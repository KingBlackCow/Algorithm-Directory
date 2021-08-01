package 구현;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20056_마법사상어와파이어볼 {
    static int n, m, k;
    static Node[][] map;
    static Queue<Node> q;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new Node[n + 1][n + 1];

        q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Node(x, y, m, s, d, 1));
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            mapClear();
            move();
            sum = divide();

        }

        System.out.println(sum);
    }

    private static void mapClear() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = new Node(0, 0, -1, 0);
            }
        }
    }

    private static void move() {
        while (!q.isEmpty()) {
            Node node = q.poll();
            int nx = node.x;
            int ny = node.y;
            int step = node.s;
            while (step-- > 0) {
                nx += dr[node.d];
                ny += dc[node.d];
                if (nx < 1) nx = n;
                else if (nx > n) nx = 1;
                if (ny < 1) ny = n;
                else if (ny > n) ny = 1;
            }
            map[nx][ny].m += node.m;
            map[nx][ny].s += node.s;
            if (map[nx][ny].d == -1) {
                map[nx][ny].d = node.d;
            } else if (map[nx][ny].d >= 0) {
                if (map[nx][ny].d % 2 != node.d % 2) {
                    map[nx][ny].d = -2;
                }
            }
            map[nx][ny].quantity++;
        }
    }

    private static int divide() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j].quantity == 1) {
                    q.add(new Node(i, j, map[i][j].m, map[i][j].s, map[i][j].d, 1));
                    sum += map[i][j].m;
                } else if (map[i][j].quantity > 1) {
                    int newM = map[i][j].m / 5;
                    int newS = map[i][j].s / map[i][j].quantity;
                    if (newM <= 0) continue;
                    if (map[i][j].d >= 0) {
                        q.add(new Node(i, j, newM, newS, 0, 1));
                        q.add(new Node(i, j, newM, newS, 2, 1));
                        q.add(new Node(i, j, newM, newS, 4, 1));
                        q.add(new Node(i, j, newM, newS, 6, 1));
                        sum += 4 * newM;
                    } else {
                        q.add(new Node(i, j, newM, newS, 1, 1));
                        q.add(new Node(i, j, newM, newS, 3, 1));
                        q.add(new Node(i, j, newM, newS, 5, 1));
                        q.add(new Node(i, j, newM, newS, 7, 1));
                        sum += 4 * newM;
                    }
                }
            }
        }
        return sum;
    }


    static class Node {
        int x;
        int y;
        int m;
        int s;
        int d;
        int quantity;

        public Node(int x, int y, int m, int s, int d, int quantity) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
            this.quantity = quantity;
        }

        public Node(int m, int s, int d, int quantity) {
            this.m = m;
            this.s = s;
            this.d = d;
            this.quantity = quantity;
        }
    }
}