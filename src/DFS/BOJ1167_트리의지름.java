package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1167_트리의지름 {

    static List<Node> list[];
    static int max = Integer.MIN_VALUE;
    static int res = Integer.MIN_VALUE;
    static boolean visit[];
    static List<Integer> tmp;
    static Node maxNode;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            while (true) {
                int node = Integer.parseInt(st.nextToken());
                if (node == -1) break;
                int edge = Integer.parseInt(st.nextToken());
                list[num].add(new Node(node, edge));
            }
            if (list[num].size() == 1) {
                tmp.add(num);
            }
        }

        Arrays.fill(visit, false);
        max = Integer.MIN_VALUE;
        dfs(3, 0);
        max= Integer.MIN_VALUE;
        visit=new boolean[n+1];
        dfs(maxNode.cnt, 0);
        res = maxNode.edge;


        System.out.println(res);
    }


    private static Node dfs(int x, int cnt) {
        visit[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            int listCnt = list[x].get(i).cnt;
            if (!visit[listCnt]) {
                dfs(listCnt, cnt + list[x].get(i).edge);
            }
        }
        if (max < cnt) {
            max = cnt;
            maxNode = new Node(x, max);
        }
        return maxNode;
    }

    static class Node {
        int cnt;
        int edge;

        public Node(int cnt, int edge) {
            this.cnt = cnt;
            this.edge = edge;
        }
    }
}