package TopologicalSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1005_ACMCraft {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int[] indegree = new int[V + 1];

            int[][] adj = new int[V + 1][V + 1];
            st = new StringTokenizer(br.readLine());
            int[] score = new int[V + 1];
            int[] sumScore = new int[V + 1];
            for (int i = 1; i <= V; i++) {
                score[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from][to] = 1;
                indegree[to]++;
            }
            int last = Integer.parseInt(br.readLine());
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                if (indegree[i] == 0) {
                    indegree[i] = 0;
                    q.add(i);
                    sumScore[i] = score[i];
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int i = 1; i <= V; i++) {
                    if (adj[node][i] == 1) {
                        sumScore[i] = Math.max(sumScore[i], sumScore[node] + score[i]);
                        if (--indegree[i] == 0) {
                            q.add(i);
                        }
                    }
                }
            }
            sb.append(sumScore[last] + "\n");
        }
        System.out.println(sb.toString());
    }
}