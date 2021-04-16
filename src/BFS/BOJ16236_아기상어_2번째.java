package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ16236_아기상어_2번째 {

    static int n;
    static int[][] ary;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean[][] visit;
    static List<Shark> list = new ArrayList<>();
    static int sharkX, sharkY;
    static Shark shark;
    static int turn;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        ary = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if (ary[i][j] == 9) {
                    shark = new Shark(i, j, 0, 2);
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        int turn = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ary[i][j] != 0 && shark.size > ary[i][j]) {
                        int dist = distance(i, j);
                        if (dist == Integer.MAX_VALUE) continue;
                        pq.add(new Fish(i, j, dist));
                    }
                }
            }
            if (pq.size() == 0) break;
            Fish fish = pq.poll();
            ary[shark.x][shark.y] = 0;
            shark.x = fish.x;
            shark.y = fish.y;
            ary[fish.x][fish.y] = 0;
            shark.cnt++;
            turn += fish.distance;
            if (shark.cnt == shark.size) {
                shark.cnt = 0;
                shark.size++;
            }

            pq.clear();
            //print();
            //System.out.println("shark location: "+shark.x+" "+shark.y);
            //System.out.println("shark size: " + shark.size);
            //System.out.println("distance: " + (turn - fish.distance) + "+" + fish.distance);
            //System.out.println();

        }
        return turn;
    }


    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Shark {
        int x;
        int y;
        int cnt;
        int size;
        int dist;

        public Shark(int x, int y, int cnt, int size) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.size = size;
        }

        public Shark(int x, int y, int cnt, int size, int dist) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.size = size;
            this.dist = dist;
        }
    }

    static class Fish implements Comparable<Fish> {
        int x;
        int y;
        int distance;

        public Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.distance == o.distance) {
                if (this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                } else {
                    return Integer.compare(this.x, o.x);
                }

            } else {
                return Integer.compare(this.distance, o.distance);
            }
        }
    }

    static private int distance(int destX, int destY) {
        Queue<Shark> q = new LinkedList<>();
        q.add(new Shark(shark.x, shark.y, shark.cnt, shark.size, 0));
        visit = new boolean[n][n];
        visit[shark.x][shark.y]=true;
        int dist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Shark tmp = q.poll();
            if (tmp.x == destX && tmp.y == destY) {
                dist = tmp.dist;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dx[i];
                int c = tmp.y + dy[i];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;
                if (ary[r][c] > tmp.size) continue;
                if (!visit[r][c]) {
                    q.add(new Shark(r, c, tmp.cnt, tmp.size, tmp.dist + 1));
                    visit[r][c] = true;
                }

            }
        }
        return dist;
    }
}