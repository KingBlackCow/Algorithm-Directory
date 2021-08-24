package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ22116_창영이와퇴근 {
    static int n;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        int left = 0;
        int right = max - min;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (bfs(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(int pivot) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visit = new boolean[n][n];
        visit[0][0] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == n - 1 && tmp.y == n - 1) return true;
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dr[i];
                int c = tmp.y + dc[i];
                if (r < 0 || c < 0 || r >= n || c >= n) continue;
                if (!visit[r][c] &&Math.abs( map[r][c] - map[tmp.x][tmp.y]) <= pivot) {
                    visit[r][c] = true;
                    q.add(new Node(r, c));
                }
            }
        }
        return false;

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
