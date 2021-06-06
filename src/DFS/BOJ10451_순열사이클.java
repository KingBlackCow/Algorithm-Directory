package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class BOJ10451_순열사이클 {
    static int n;
    static int[] ary;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            ary = new int[n + 1];
            visit = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                ary[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    dfs(i);
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int x) {
        visit[x] = true;
        if (!visit[ary[x]]) {
            dfs(ary[x]);
        }
    }
}