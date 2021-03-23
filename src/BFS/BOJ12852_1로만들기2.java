package BFS;

import java.io.*;
import java.util.*;

public class BOJ12852_1로만들기2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        bfs(n);

        bw.close();
        br.close();
    }

    private static void bfs(int x) {

        Queue<Node> q = new LinkedList<>();
        List<Integer> listTmp = new ArrayList<>();
        listTmp.add(x);
        q.add(new Node(x, 0, listTmp));
        boolean visit[] = new boolean[1000001];
        visit[x] = true;
        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == 1) {
                System.out.println(tmp.turn);
                for (int i = 0; i < tmp.list.size(); i++) {
                    System.out.print(tmp.list.get(i) + " ");
                }
                System.exit(0);
            }
            if (tmp.x < 1) continue;
            if (tmp.x % 3 == 0) {
                List<Integer> list2 = new ArrayList<>(tmp.list);
                int k = tmp.x / 3;
                if (k >= 0 && !visit[k]) {
                    list2.add(k);
                    q.add(new Node(k, tmp.turn + 1, list2));
                    visit[k] = true;
                }
            }
            if (tmp.x % 2 == 0) {
                int k = tmp.x / 2;
                if (k >= 0 && !visit[k]) {
                    List<Integer> list2 = new ArrayList<>(tmp.list);
                    list2.add(k);
                    q.add(new Node(k, tmp.turn + 1, list2));
                    visit[k] = true;
                }
            }
            if (tmp.x - 1 > 1) {
                int k = tmp.x - 1;
                if (k >= 0 && !visit[k]) {
                    List<Integer> list2 = new ArrayList<>(tmp.list);
                    list2.add(k);
                    q.add(new Node(k, tmp.turn + 1, list2));
                    visit[k] = true;
                }
            }
        }


    }

    static class Node {
        int x;
        int turn;
        List<Integer> list;

        Node(int x, int turn, List<Integer> list) {
            this.x = x;
            this.turn = turn;
            this.list = list;

        }


    }
}