import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static String[][] ary = new String[8][8];
    static boolean visit[][];
    static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1, 0};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1, 0};
    static Queue<Node> wallQ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visit = new boolean[8][8];
        wallQ = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                ary[i][j] = str[j];

            }
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (ary[i][j].equals("#")) {
                    wallQ.add(new Node(i, j));
                }
            }
        }

        if (bfs()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(7, 0));

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int t = 0; t < qSize; t++) {
                Node tmp = q.poll();
                if (tmp.x == 0 && tmp.y == 7) return true;
                if (ary[tmp.x][tmp.y].equals("#")) continue;
                for (int i = 0; i < 9; i++) {
                    int r = tmp.x + dr[i];
                    int c = tmp.y + dc[i];
                    if (r < 0 || r >= 8 || c < 0 || c >= 8) continue;
                    if (ary[r][c].equals(".")) {
                        q.add(new Node(r, c));
                    }
                }
            }
            int wallQsize = wallQ.size();
            for (int i = 0; i < wallQsize; i++) {
                Node wallTmp = wallQ.poll();
                int x = wallTmp.x;
                int y = wallTmp.y;
                ary[x][y] = ".";
                x++;
                if (x < 8) {
                    ary[x][y] = "#";
                    wallQ.add(new Node(x, y));
                }
            }
        }
        return false;
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
