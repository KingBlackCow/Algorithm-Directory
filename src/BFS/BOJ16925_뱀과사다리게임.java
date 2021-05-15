package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16925_뱀과사다리게임 {
    static boolean[] visit;
    static int n, m;
    static int[] point;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[101];
        point = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            point[f] = s;
        }
        bfs();
    }


    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        visit[1] = true;
        while (!q.isEmpty()) {
            int[] cnt = q.poll();

            if (cnt[0] == 100) {
                System.out.println(cnt[1]);
                System.exit(0);
            }
            for (int i = 1; i <= 6; i++) {
                if (cnt[0] + i <= 100) {

                    if (!visit[cnt[0] + i]) {
                        visit[cnt[0] + i] = true;
                        if(point[cnt[0]+i]!=0){
                            visit[point[cnt[0]+i]] = true;
                            q.add(new int[]{point[cnt[0]+i], cnt[1] + 1});
                            continue;
                        }
                        q.add(new int[]{cnt[0] + i, cnt[1] + 1});
                    }
                }
            }
        }
    }
}
