package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17406_배열돌리기4 {
    static int n, m, order;
    static int[][] map;
    static boolean[] visit;
    static Deque<Integer> q = new ArrayDeque<>();
    static List<Node> nodes = new LinkedList<>();
    static int[] ary;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        ary = new int[order];
        visit=new boolean[order];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int range = Integer.parseInt(st.nextToken());
            //rotate(x, y, range);
            nodes.add(new Node(x, y, range));
        }
        dfs(0);

        System.out.println(min);
    }

    private static void dfs(int x) {
        if (x == order) {
            int[][] map2 = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    map2[i][j] = map[i][j];
                }
            }
            for (int i = 0; i < order; i++) {
                map2 = rotate(nodes.get(ary[i]).x, nodes.get(ary[i]).y, nodes.get(ary[i]).range, map2);
            }
            min = Math.min(min, check(map2));
            return;
        }
        for (int i = 0; i < order; i++) {
            if(!visit[i]){
                visit[i]=true;
                ary[x] = i;
                dfs(x + 1);
                visit[i]=false;
            }

        }
    }


    private static int check(int[][] map) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= m; j++) {
                sum += map[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static int[][] rotate(int x, int y, int range, int[][] map) {
        for (int n = 1; n <= range; n++) {
            int r = x - n;
            int c = y - n;

            for (int dir = 0; dir < 4; dir++) {
                if (dir == 0) {
                    for (int j = 0; j < 2 * n; j++) {
                        q.add(map[r][++c]);
                    }
                } else if (dir == 1) {

                    for (int j = 0; j < 2 * n; j++) {
                        q.add(map[++r][c]);
                    }
                } else if (dir == 2) {

                    for (int j = 0; j < 2 * n; j++) {
                        q.add(map[r][--c]);
                    }
                } else if (dir == 3) {
                    for (int j = 0; j < 2 * n; j++) {
                        q.add(map[--r][c]);
                    }
                }
            }
            q.addFirst(q.pollLast());
            q.addFirst(q.pollLast());
            r = x - n;
            c = y - n;
            for (int dir = 0; dir < 4; dir++) {
                if (dir == 0) {
                    for (int j = 0; j < 2 * n; j++) {
                        map[r][c++] = q.poll();
                    }
                } else if (dir == 1) {

                    for (int j = 0; j < 2 * n; j++) {
                        map[r++][c] = q.poll();
                    }
                } else if (dir == 2) {

                    for (int j = 0; j < 2 * n; j++) {
                        map[r][c--] = q.poll();
                    }
                } else if (dir == 3) {

                    for (int j = 0; j < 2 * n; j++) {
                        map[r--][c] = q.poll();
                    }
                }
            }

        }
        return map;
    }

    static class Node {
        int x;
        int y;
        int range;

        public Node(int x, int y, int range) {
            this.x = x;
            this.y = y;
            this.range = range;
        }
    }
}
