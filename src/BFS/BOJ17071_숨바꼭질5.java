package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17071_숨바꼭질5 {
    static int n;
    static int k;
    static int[][] visit;
    static int turn = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new int[2][500001];
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        Arrays.fill(visit[0],-1);
        Arrays.fill(visit[1],-1);
        if(n==k) {
            System.out.println(0);
            System.exit(0);
        }
        bfs();
        System.out.println(-1);

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList();
        q.add(n);
        visit[0][n] = 0;
        while (!q.isEmpty()) {
            turn++;
            k += turn;
            if (k > 500000) return;
            int cnt = turn % 2 == 0 ? 0 : 1;

            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                int tmp = q.poll();
                if (tmp - 1 >= 0) {
                    if (visit[cnt][tmp- 1] == -1) {
                        visit[cnt][tmp- 1] = turn;
                        q.add(tmp - 1);
                    }
                }
                if (tmp * 2 <= 500000) {
                    if (visit[cnt][tmp * 2] == -1) {
                        visit[cnt][tmp * 2] = turn;
                        q.add(tmp * 2);
                    }
                }

                if (tmp + 1 <= 500000) {
                    if (visit[cnt][tmp + 1] == -1) {
                        visit[cnt][tmp + 1] = turn;
                        q.add(tmp + 1);
                    }
                }
            }
            if (visit[cnt][k] != -1) {
                System.out.println(turn);
                System.exit(0);
            }
        }
    }
}