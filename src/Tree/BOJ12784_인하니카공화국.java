package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ12784_인하니카공화국 {


    static boolean[] visit;
    static List<Edge> list[];
    static int INF = 987654321;

    static int inorder(int x, int cnt) {
        boolean flag = false;
        int sum = 0;
        visit[x] = true;
        for (Edge edge : list[x]) {
            if (!visit[edge.to]) {
                flag = true;
                sum += inorder(edge.to, edge.weight);
            }
        }
        if (!flag) {
            return cnt;
        } else {
            return Math.min(sum, cnt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            visit = new boolean[n + 1];
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                list[x].add(new Edge(y, z));
                list[y].add(new Edge(x, z));
            }

            int answer = inorder(1, INF);
            if (answer == INF)
                answer = 0;
            System.out.println(answer);
        }
    }

    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}