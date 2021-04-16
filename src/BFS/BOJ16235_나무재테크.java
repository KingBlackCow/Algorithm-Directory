package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ16235_나무재테크 {

    static int n, m, k;
    static int[][] ary;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static PriorityQueue<Tree> pq = new PriorityQueue<>();
    static Queue<Tree> deadQ = new LinkedList<>();
    static Queue<Tree> qTmp = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ary = new int[n + 1][n + 1];
        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ary[i][j] = 5;
            }
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Tree(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(pq.size());
    }

    private static void winter() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ary[i][j] += map[i][j];
            }
        }
    }

    private static void autumn() {
        int pqSize = pq.size();

        for (int i = 0; i < pqSize; i++) {
            Tree tree = pq.poll();
            if (tree.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int r = tree.x + dx[j];
                    int c = tree.y + dy[j];
                    if (r < 1 || c < 1 || r >= n + 1 || c >= n + 1) continue;
                    qTmp.add(new Tree(r, c, 1));
                }
            }
            qTmp.add(tree);
        }
        while (!qTmp.isEmpty()) {
            pq.add(qTmp.poll());
        }
    }

    private static void summer() {
        while (!deadQ.isEmpty()) {
            Tree tree = deadQ.poll();
            ary[tree.x][tree.y] += tree.age / 2;
        }
    }

    private static void spring() {
        int pqSize = pq.size();
        for (int i = 0; i < pqSize; i++) {
            Tree tree = pq.poll();
            if (ary[tree.x][tree.y] >= tree.age) {
                ary[tree.x][tree.y] -= tree.age;
                tree.age++;
                qTmp.add(tree);
            } else {
                deadQ.add(tree);
            }
        }
        while (!qTmp.isEmpty()) {
            pq.add(qTmp.poll());
        }
    }

    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ary[i][j] + " ");
            }
            System.out.println();
        }
    }

}