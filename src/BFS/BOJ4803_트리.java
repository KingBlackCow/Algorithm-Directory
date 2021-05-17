package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4803_트리 {
    static int n, m;
    static Set<Integer> set = new HashSet<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int sx, sy;
    static char[][] map;
    static boolean[] visit;
    static List<Integer> list[];
    static boolean finished[];
    static int[] ary;
    static int res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int turn = 1;

        while (true) {
            //res=0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            visit = new boolean[n + 1];
            ary = new int[n + 1];
            finished = new boolean[n + 1];


            if (n == 0 && m == 0) break;
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    res = 0;
                    cnt += bfs(i);
                }
            }

            if (cnt > 1) {
                sb.append("Case " + turn++ + ": " + "A forest of " + cnt + " trees.\n");
            } else if (cnt == 1) {
                sb.append("Case " + turn++ + ": " + "There is one tree.\n");
            } else {
                sb.append("Case " + turn++ + ": " + "No trees.\n");
            }

        }

        System.out.println(sb.toString());
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int node = 0;
        int edge = 0;
        while (!q.isEmpty()) {
            int cnt = q.poll();
            node += 1;
            visit[cnt] = true;
            for (int next : list[cnt]) {
                edge++;
                if (!visit[next]) {
                    q.add(next);
                }
            }
        }
        return (edge / 2) + 1 == node ? 1 : 0;
    }
}
