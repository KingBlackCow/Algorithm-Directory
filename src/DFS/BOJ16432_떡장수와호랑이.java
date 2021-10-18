package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16432_떡장수와호랑이 {
    static List<Integer>[] list;
    static int T;
    static int[] ary;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        list = new ArrayList[T];
        visit = new boolean[T][10];
        ary = new int[T];
        for (int i = 0; i < T; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        dfs(0, 0);
        System.out.println(-1);
    }

    private static void dfs(int day, int past) {
        if (day == T) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : ary) {
                sb.append(i + "\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
            return;
        }
        for (Integer i : list[day]) {
            if (i != past && !visit[day][i]) {
                visit[day][i] = true;
                ary[day] = i;
                dfs(day + 1, i);
            }
        }
    }
}


