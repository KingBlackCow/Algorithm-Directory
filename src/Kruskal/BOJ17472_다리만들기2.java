package Kruskal;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472_다리만들기2 {

    static int n, m;
    static int[][] ary;

    static int islandNum;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[] parents;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ary = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        islandNum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]&&ary[i][j] == 1) {
                    bfs(i, j, islandNum);
                    islandNum++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ary[i][j] != 0) {
                    makeBridge(i, j, ary[i][j]);
                }
            }
        }
        parents=new int[islandNum];
        make();
        int res=0;
        int bridgeCnt=0;
        //int pqSize=pq.size();
        while (!pq.isEmpty()){
            Edge edge=pq.poll();
            if(union(edge.from, edge.to)){
                res+=edge.weight;
                bridgeCnt++;
            }
        }

        if(bridgeCnt!=islandNum-2){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }

    private static void makeBridge(int x, int y, int num) {
        for (int i = 0; i < 4; i++) {
            int r = x;
            int c = y;
            int distance = 0;
            while (true) {
                r += dr[i];
                c += dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) break;
                if (ary[r][c] == num) {
                    break;
                }
                if (ary[r][c] == 0) {
                    distance++;
                } else if (ary[r][c] != 0 && ary[r][c] != num) {
                    if (distance > 1) {
                        pq.add(new Edge(num, ary[r][c], distance));
                    }
                    break;
                }
            }
        }

    }

    private static void bfs(int x, int y, int num) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visit[x][y] = true;
        ary[x][y]=num;
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= m) continue;
                if (!visit[r][c] && ary[r][c] == 1) {
                    q.add(new Point(r, c));
                    visit[r][c] = true;
                    ary[r][c] = num;
                }
            }
        }
    }

    static void make() {
        for (int i = 0; i < islandNum; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        parents[a] = findSet(parents[a]);
        return parents[a];
    }

    public static boolean union(int s, int e) {
        int aRoot = findSet(s);
        int bRoot = findSet(e);
        if (aRoot == bRoot) return false;

        parents[aRoot] = e;
        return true;

    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return Integer.compare(this.weight, e.weight);
        }
    }
}

