import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    static int n, m;
    static String[][] ary;
    static int[][] visit;
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ary = new String[n][m];
            visit = new int[n][m];


            q=new LinkedList<>();
            for (int i = 0; i < n; i++) {
                String str[] = br.readLine().split("");
                for (int j = 0; j < m; j++) {
                    ary[i][j] = str[j];
                    if (ary[i][j].equals("W")) {
                        q.add(new Node(i, j, 1));
                        visit[i][j] = -1;
                    }
                }
            }
            bfs();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visit[i][j] != -1) {
                        sum += visit[i][j];
                    }
                }
            }

            sb.append("#" + tc + " " + sum+"\n");
        }
        System.out.println(sb.toString());
        br.close();
        System.exit(0);
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                Node node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int r = node.x + dr[i];
                    int c = node.y + dc[i];
                    int turn = node.turn;
                    if (r < 0 || r >= n || c < 0 || c >= m) continue;
                    if (visit[r][c] == 0) {
                        q.add(new Node(r, c, turn + 1));
                        visit[r][c] = turn;
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int turn;

        Node(int x, int y, int turn) {
            this.x = x;
            this.y = y;
            this.turn = turn;
        }
    }
}
