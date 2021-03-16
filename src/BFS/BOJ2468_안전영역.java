package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class BOJ2468_안전영역 {
    static int n;
    static boolean[][] visit;
    static int[][] ary;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        ary = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, ary[i][j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int k = 0; k <= max; k++) {
            int cnt = 0;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ary[i][j] > k && !visit[i][j]) {
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }
            list.add(cnt);
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
    }

    private static void bfs(int a, int b, int height) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(a, b));
        visit[a][b] = true;

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            for (int i = 0; i < 4; i++) {
                int r = tmp.x + dx[i];
                int c = tmp.y + dy[i];
                if (r < 0 || r >= n || c < 0 || c >= n) continue;
                if (!visit[r][c] && ary[r][c] > height) {
                    q.add(new Node(r, c));
                    visit[r][c] = true;
                }
            }

        }
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