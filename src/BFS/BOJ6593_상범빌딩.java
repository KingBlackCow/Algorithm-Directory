package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ6593_상범빌딩 {
    static int L, R, C;
    static char[][][] map;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, - 1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int startX, startY, startZ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) break;
            map = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = str.charAt(k);
                        if (map[i][j][k] == 'S') {
                            startZ = i;
                            startX = j;
                            startY = k;
                        }
                    }
                }
                br.readLine();
            }
            int tmp = bfs();
            if (tmp != -1) {
                sb.append("Escaped in " + tmp + " minute(s)." + "\n");
            } else {
                sb.append("Trapped!\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startZ, startX, startY));
        boolean[][][] visit = new boolean[L][R][C];
        visit[startZ][startX][startY] = true;
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                Node tmp = q.poll();
                if (map[tmp.z][tmp.x][tmp.y] == 'E') {
                    return turn;
                }
                for (int i = 0; i < 6; i++) {
                    int newZ = tmp.z + dh[i];
                    int newX = tmp.x + dr[i];
                    int newY = tmp.y + dc[i];
                    if (newZ < 0 || newZ >= L || newX < 0 || newX >= R || newY < 0 || newY >= C) continue;
                    if (!visit[newZ][newX][newY] && map[newZ][newX][newY] != '#') {
                        visit[newZ][newX][newY] = true;
                        q.add(new Node(newZ, newX, newY));
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    static class Node {
        int z;
        int x;
        int y;


        public Node(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }

}