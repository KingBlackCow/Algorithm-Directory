package TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2623_음악프로그램 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int[] indegree = new int[V + 1];
        int[][] adj = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                adj[from][to] = 1;
                indegree[to]++;
                from = to;
            }
        }
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            sb.append(node).append("\n");
            for (int i = 1; i <= V; i++) {
                if (adj[node][i] == 1) {
                    if (--indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }

        if (cnt != V) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }

    }

}
