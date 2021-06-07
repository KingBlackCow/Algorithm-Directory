package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15900_나무탈출 {
    static int n;
    static List<Integer> list[];
    static long max = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st;
        visit = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }
        dfs(1, 0);
        String res = "";
        if (max % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static void dfs(int x, int cnt) {
        visit[x] = true;
        boolean flag = true;
        for (Integer edge : list[x]) {
            if (!visit[edge]) {
                flag = false;
                dfs(edge, cnt + 1);
            }
        }
        if (flag) {
            max += cnt;
        }

    }


}
