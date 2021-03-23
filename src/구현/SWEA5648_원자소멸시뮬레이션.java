package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SWEA5648_원자소멸시뮬레이션 {

    static int n;
    static int[][] ary;
    static Queue<Node> q;
    static boolean[][] visit;
    static int res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            ary = new int[4001][4001];
            q = new LinkedList<>();
            visit = new boolean[4001][4001];
            res = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
                int r = (x + 1000) * 2;
                int c = (y + 1000) * 2;
                q.add(new Node(r, c, dir, energy));
                visit[r][c] = true;
            }
            bfs();
            sb.append("#" + tc + " " + res + "\n");
        }
        System.out.println(sb.toString());
        System.exit(0);
    }

    private static void bfs() {
        List<Node> list;
        List<int[]> rc;
        while (!q.isEmpty()) {
            list = new ArrayList<>();
            rc = new ArrayList<>();
            int qSize = q.size();
            int energySum = 0;
            for (int i = 0; i < qSize; i++) {
                Node tmp = q.poll();
                int r = tmp.x;
                int c = tmp.y;
                if (tmp.dir == 0) {
                    c += 1;
                } else if (tmp.dir == 1) {
                    c -= 1;
                } else if (tmp.dir == 2) {
                    r -= 1;
                } else if (tmp.dir == 3) {
                    r += 1;
                }
                if (r < 0 || c < 0 || r >= 4000 || c >= 4000) continue;
                if (!visit[r][c]) {
                    visit[r][c] = true;
                    list.add(new Node(r, c, tmp.dir, tmp.energy));
                } else {
                    rc.add(new int[]{r, c});
                    if (!list.isEmpty()) {
                        for (int j = 0; j < list.size(); j++) {
                            if (list.get(j).x == r && list.get(j).y == c) {
                                energySum += list.get(j).energy;
                                list.remove(list.get(j));
                                break;
                            }
                        }
                    }
                    energySum += tmp.energy;
                }
                visit[tmp.x][tmp.y] = false;
            }
            res += energySum;
            for (int j = 0; j < rc.size(); j++) {
                int x = rc.get(j)[0];
                int y = rc.get(j)[1];
                visit[x][y] = false;
            }
            for (int i = 0; i < list.size(); i++) {
                q.add(list.get(i));
            }
            if (q.size() == 1) break;
        }
    }

    static class Node {
        int x;
        int y;
        int dir;
        int energy;

        public Node(int x, int y, int dir, int energy) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.energy = energy;
        }
    }

}
