package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1240_노드사이의거리 {
    static int n, m;
    static List<Node> list[];
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
            list[end].add(new Node(start, weight));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, end) + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfs(int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visit= new boolean[n+1];
        while (!q.isEmpty()) {
            Node cnt = q.poll();
            if (cnt.x == end) return cnt.weight;
            for (Node node : list[cnt.x]) {
                if(!visit[node.x]){
                    visit[node.x] =true;
                    q.add(new Node(node.x, cnt.weight + node.weight));

                }
            }
        }
        return 0;
    }

    static class Node {
        int x;
        int weight;

        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }
}