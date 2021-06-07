package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18126_너구리구구 {
    static int n;
    static List<Edge> list[];
    static long max = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        visit = new boolean[n + 1];
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());
            list[first].add(new Edge(second, weight));
            list[second].add(new Edge(first, weight));
        }
        dfs(1, 0);
        System.out.println(max);
    }

    private static void dfs(int x, long cnt) {
        visit[x] = true;
        max = Math.max(max, cnt);
        for (Edge edge : list[x]) {
            if (!visit[edge.to]) {
                dfs(edge.to, cnt + edge.weight);
            }
        }
    }

    static class Edge {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
