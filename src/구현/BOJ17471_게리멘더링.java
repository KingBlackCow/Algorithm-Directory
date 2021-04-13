package 구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ17471_게리멘더링 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] ary;
    static List<Integer>[] list;
    static int[] arr;
    static boolean[] visit;
    static boolean[] connect;
    static int min;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        ary = new int[n + 1];
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int connect = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= connect; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            dfs(0, 1, i);
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

        bw.close();
        br.close();
    }

    private static void dfs(int x, int cnt, int turn) {
        if (x == turn) {
            connect = new boolean[n + 1];
            /*checkVisit(arr[0]);
            boolean visitAll = true;
            for (int i = 0; i < turn; i++) {
                if (!connect[arr[i]]) {
                    visitAll = false;
                    break;
                }
            }*/
            for (int i = 1; i <= n; i++) {
                if (visit[i]) {
                    checkVisit(i);
                    break;
                }
            }
            boolean visitAll = true;
            for (int i = 1; i <= n; i++) {
                if (visit[i] && !connect[i]) {
                    visitAll = false;
                    break;
                }
            }
            ////////////////////////////////////////////
            connect = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    checkNotVisit(i);
                    break;
                }
            }
            boolean visitNotAll = true;
            for (int i = 1; i <= n; i++) {
                if (!visit[i] && !connect[i]) {
                    visitNotAll = false;
                    break;
                }
            }
            int visitCity = 0;
            int visitNotCity = 0;

            if (visitAll && visitNotAll) {
                for (int i = 1; i <= n; i++) {
                    if (visit[i]) {
                        visitCity += ary[i];
                    } else {
                        visitNotCity += ary[i];
                    }
                }
                min = Math.min(min, Math.abs(visitCity - visitNotCity));
            }
            return;
        }
        for (int i = cnt; i <= n; i++) {
            arr[x] = i;
            visit[i] = true;
            dfs(x + 1, i + 1, turn);
            visit[i] = false;
        }
    }

    private static void checkVisit(int x) {
        connect[x] = true;
        for (Integer i : list[x]) {
            if (!connect[i] && visit[i]) {
                checkVisit(i);
            }
        }
    }

    private static void checkNotVisit(int x) {
        connect[x] = true;
        for (Integer i : list[x]) {
            if (!connect[i] && !visit[i]) {
                checkNotVisit(i);
            }
        }
    }
}