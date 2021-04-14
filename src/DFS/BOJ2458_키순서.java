package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ2458_키순서 {

    static int n, m;

    static boolean visit[];
    static List<Integer> list[];
    static Node[] node;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        node = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = new Node(i, 0);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(s);
        }
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            max = 0;
            dfs(i , i, 0);
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int res = --node[i].fanIn + --node[i].fanOut;
            if (res == n - 1) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static void dfs(int start, int x, int cnt) {
        visit[x] = true;
        node[x].fanIn++;
        node[start].fanOut++;
        for (Integer i : list[x]) {
            if (!visit[i])
                dfs(start, i, ++cnt);
        }
    }

    static class Node {
        int node;
        int fanIn;
        int fanOut;

        public Node(int node, int fanIn) {
            this.node = node;
            this.fanIn = fanIn;
        }
    }
}