package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ13913_숨바꼭질4 {
    static int n;
    static int k;
    static int[] visit;
    static int min = Integer.MAX_VALUE;
    private static int[] parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new int[100001];
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(min);
        Stack<Integer> s = new Stack<>();
        int idx = k;
        while (idx != n) {
            s.push(idx);
            idx = parent[idx];
        }
        s.push(idx);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList();
        q.add(n);
        visit[n] = 1;
        while (!q.isEmpty()) {
            int tmp = q.poll();

            if (tmp == k) {
                if (min > visit[tmp]) {
                    min = visit[tmp]-1;
                }
                return;
            }

            if (tmp - 1 >= 0) {
                if (visit[tmp - 1] == 0) {
                    visit[tmp - 1] = visit[tmp] + 1;
                    parent[tmp - 1] = tmp;
                    q.add(tmp - 1);
                }
            }
            if (tmp * 2 <= 100000) {
                if (visit[tmp * 2] == 0) {
                    visit[tmp * 2] = visit[tmp] + 1;
                    parent[tmp * 2] = tmp;
                    q.add(tmp * 2);
                }
            }

            if (tmp + 1 <= 100000) {
                if (visit[tmp + 1] == 0) {
                    visit[tmp + 1] = visit[tmp] + 1;
                    parent[tmp + 1] = tmp;
                    q.add(tmp + 1);
                }
            }


        }
    }


}