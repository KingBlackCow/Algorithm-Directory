package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1963_소수경로 {
    static int a, b;
    static boolean[] visit;
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        prime = new boolean[10000];
        prime[0] = prime[1] = true;

        for (int i = 2; i * i < 10000; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    prime[j] = true;
                }
            }
        }
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());


            int res = bfs();
            if(res==-1){
                sb.append("Impossible\n");
                continue;
            }
            sb.append(res + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        visit = new boolean[10000];
        visit[a] = true;
        int turn = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int qlen = 0; qlen < qSize; qlen++) {
                int cnt = q.poll();
                if (cnt == b) {
                    return turn;
                }
                String str = String.valueOf(cnt);
                for (int i = 0; i <= 3; i++) {
                    String tmp1 = str.substring(0, i);
                    String tmp2 = str.substring(i + 1);
                    String tmp = "";
                    for (int j = 0; j < 10; j++) {
                        if (i == 0 && j == 0) continue;
                        tmp = tmp1 + String.valueOf(j) + tmp2;
                        int next = Integer.parseInt(tmp);
                        if (!prime[next]) {
                            if (visit[next]) continue;
                            visit[next] = true;
                            q.add(next);
                        }
                    }
                }
            }
            turn++;
        }
        return -1;
    }
}