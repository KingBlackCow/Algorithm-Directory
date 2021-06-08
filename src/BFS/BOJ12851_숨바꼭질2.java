package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851_숨바꼭질2 {
    static int n;
    static int k;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[100001];
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(min);
        System.out.println(cnt);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList();
        q.add(new Node(n, 0));

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            if (tmp.x == k) {
                if (min > tmp.time) {
                    min = tmp.time;
                    cnt = 1;
                } else if (tmp.time == min) {
                    cnt++;
                }
            }

            if (tmp.x - 1 >= 0) {
                if (!visit[tmp.x - 1]) {
                    q.add(new Node(tmp.x - 1, tmp.time + 1));
                }
            }
            if (tmp.x * 2 <= 100000) {
                if (!visit[tmp.x * 2]) {
                    q.add(new Node(tmp.x * 2, tmp.time + 1));
                }
            }

            if (tmp.x + 1 <= 100000) {
                if (!visit[tmp.x + 1]) {
                    q.add(new Node(tmp.x + 1, tmp.time + 1));
                }
            }
            if (visit[tmp.x]) continue;
            visit[tmp.x] = true;
        }
    }

    static class Node {
        int x;
        int time;

        Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}