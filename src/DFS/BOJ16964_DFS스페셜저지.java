package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16964_DFS스페셜저지 {
    static int n, c;
    static int[] parents;
    static List<Integer> list[];
    static boolean[] visit;
    static int[] ary;
    static int res = 1;
    static int[] depths;
    static Set<Integer> set = new HashSet<>();
    static boolean flag;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        depths = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(s);
            list[s].add(f);
        }
        ary = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        idx = 1;
        flag = true;
        if(ary[0] != 1) {
            System.out.println(0);
            return;
        }
        dfs(1);
        res = flag == true ? 1 : 0;
        System.out.println(res);
    }

    private static void dfs(int x) {
        if (visit[x]) return;
        visit[x] = true;
        Set<Integer> set = new HashSet<>();
        for (Integer i:list[x]) {
            if(visit[i])continue;
            set.add(i);
        }
        if(set.size()==0)return;
        if(set.contains(ary[idx])){
            dfs(ary[idx++]);
        }else {
            flag = false;
        }
    }


}